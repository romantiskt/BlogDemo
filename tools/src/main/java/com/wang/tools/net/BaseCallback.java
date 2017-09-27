
package com.wang.tools.net;


import com.google.gson.Gson;
import com.wang.tools.common.LogUtils;
import com.wang.tools.common.SingleToast;
import com.basenet.net.callback.Callback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 网络请求Callback.
 */
public class BaseCallback<T extends BaseResponse> extends Callback<T> {

    private BaseRequest request;
    private Class<T> responseClazz;
    private NetListener<T> netListener;
    private String url;
    private String responseBody;
    private Gson gson = new Gson();

    public BaseCallback(BaseRequest request, Class<T> responseClazz, NetListener<T> netListener) {
        this.request = request;
        this.responseClazz = responseClazz;
        this.netListener = netListener;
        this.url = request.getUrl();
    }

    @Override
    public T parseNetworkResponse(Response response, int id) throws Exception {
        responseBody = response.body().string();
        LogUtils.n("请求结果_____" + responseBody);
        // 此处Json可能出现转换错误
        response.body().close();
        return gson.fromJson(responseBody, responseClazz);
    }


    @Override
    public void onError(Call call, Exception e, int id) {
        // 网络相关错误(无网络连接，Json转换异常等) 处理
        // 包括上传友盟,前台打印错误信息
        // 网络错误封装
        NetErrorInfo netErrorInfo = NetErrorHelper.generateNetErrorInfo(e);
        if (ServerCode.CANCELED == netErrorInfo.getCode()) {
            LogUtils.n("网络请求已取消,回调已被拦截");
        } else {
            if (netListener != null) {
                if (netListener.onError(netErrorInfo)) {
                    // 给用户友好提示

                    SingleToast.getInstance().showButtomToast(netErrorInfo.getMessage());
                }
                netListener.onFinal();
            }
        // 打印错误到控制台,并上传部分错误到友盟
        NetErrorHelper.reportError(BaseCallback.class, url, request, netErrorInfo, responseBody);
        }

    }

    @Override
    public void onResponse(T response, int id) {
        // 业务相关错误 与 成功
        String code = response.getResult();
        if (ServerCode.SUCCESS.equals(code)) {
            // 接口访问成功
            // 接口分页的时候会有问题,故不在此处理缓存
            if (netListener != null) {
                netListener.onSuccess(response);
            }
        } else {
            // 业务错误封装
            BizErrorInfo bizErrorInfo = BizErrorHelper.generateBizErrorInfo(response);

            String message = null;
            if (ServerCode.NOLOGIN.equals(code)) {
                // Token失效 --> 跳到登陆页面
                message = bizErrorInfo.getMessage();
//                ActivityUtils.toLoginActivity(UIUtils.getContext());
            } else if (ServerCode.ERRO.equals(code)) {
                message = bizErrorInfo.getMessage();
            } else {
                // 由于缺少参数的信息需要控制台反应出来，因此对toast message重新赋值
//                message = UIUtils.getString(R.string.biz_error_info);
            }

            if (netListener != null) {
                if (netListener.onFailed(bizErrorInfo)) {
                    // 提示用户业务错误 --> 打印到控制台的是全面的信息
                    SingleToast.getInstance().showButtomToast(message);
                }
            }

            // 打印错误到控制台,并上传部分错误(缺少参数)到友盟
            BizErrorHelper.reportError(BaseCallback.class, url, request, bizErrorInfo);
        }

        if (netListener != null) {
            netListener.onFinal();
        }
    }


}
