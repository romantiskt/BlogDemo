
package com.wang.tools.net;

import android.text.TextUtils;

import com.wang.tools.common.LogUtils;


/**
 * 网络业务错误帮助类.
 */
public class BizErrorHelper {

    /**
     * 解析服务端返回的错误信息并封装为BaseResponseType.
     *
     * @param baseResponse 服务端响应的内容
     * @return 业务错误信息
     */
    public static BizErrorInfo generateBizErrorInfo(BaseResponse baseResponse) {

        BizErrorInfo bizErrorInfo;
        String code = baseResponse.getResult();
        String message = null;

        if (code.equals(ServerCode.ERRO)) {
            // 接口访问失败,一般是缺少参数引起
            message = baseResponse.getResultMsg();
        } else if (code.equals(ServerCode.NOLOGIN)) {
            // Token失效
                        message = "用户已在其它设备登录或是登录超时";
        }
        //        else if (code == ServerCode.FAILED_MESSAGE) {
        //            message = baseResponse.getMsg();
        //        }
        else {
            // 其他错误
            message = baseResponse.getResultMsg();
        }

        bizErrorInfo = new BizErrorInfo(code, message, baseResponse);
        return bizErrorInfo;
    }

    /**
     * 报告业务错误, 在前台打印日志信息, 远程通过友盟上传错误日志.
     *
     * @param clazz        类
     * @param url          地址
     * @param request      请求信息
     * @param bizErrorInfo 错误信息
     */
    public static void reportError(final Class clazz, final String url, final BaseRequest request, final BizErrorInfo bizErrorInfo) {
        if (clazz == null || TextUtils.isEmpty(url) || request == null || bizErrorInfo == null) {
            return;
        }
        String code = bizErrorInfo.getCode();
        String content = "错误代码 : " + code + "\nurl : " + url + "\n请求参数 : " + request.toJson() + "\n响应结果 : " + bizErrorInfo.getResponse().toJson();

        if (code.equals(ServerCode.ERRO)) {
            BusinessException businessException = new BusinessException();
            ExceptionUtils.addMessage(businessException, clazz, "Response-Result : " + bizErrorInfo.getResponse().toJson());
            ExceptionUtils.addMessage(businessException, clazz, "Request-Params : " + request.toJson());
            ExceptionUtils.addMessage(businessException, clazz, "Server-ParserError, code : " + code + ", url : " + url);
           /* 上传错误*/
            //            MobclickAgent.reportError(UIUtils.getContext(), businessException);
//            CrashReport.postCatchedException(businessException);
        }

        // 前台打印信息
        LogUtils.n(content);
    }
}
