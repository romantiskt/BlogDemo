
package com.wang.tools.net;


import com.wang.tools.common.UIUtils;
import com.basenet.net.callback.FileCallBack;

import java.io.File;

import okhttp3.Call;

/**
 * 下载文件CallBack.
 */
public class BaseFileCallBack extends FileCallBack {

    private DownloadListener mListener;

    private String mUrl;

    private BaseRequest mRequest;

    public BaseFileCallBack(BaseRequest request, String destFileDir, String destFileName, DownloadListener listener) {
        super(destFileDir, destFileName);
        mRequest = request;
        mUrl = request.getUrl();
        mListener = listener;
    }



    @Override
    public void onError(Call call, Exception e, int id) {
        // 网络相关错误(无网络连接，Json转换异常等) 处理
        // 包括上传友盟,前台打印错误信息

        // 网络错误封装
        NetErrorInfo netErrorInfo = NetErrorHelper.generateNetErrorInfo(e);

        if (mListener != null) {
            if (mListener.onError(netErrorInfo)) {
                // 给用户友好提示
                UIUtils.showToast(netErrorInfo.getMessage());
            }
            mListener.onFinal();
        }

        // 打印错误到控制台,并上传部分错误到友盟
        NetErrorHelper.reportError(BaseCallback.class, mUrl, mRequest, netErrorInfo, null);
    }

    @Override
    public void onResponse(File file, int id) {
        if (mListener != null) {
            mListener.onSuccess(file);
            mListener.onFinal();
        }
    }
}
