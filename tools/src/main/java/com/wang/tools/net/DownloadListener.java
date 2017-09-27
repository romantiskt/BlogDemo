
package com.wang.tools.net;


import java.io.File;

/**
 * 文件下载的接口回掉.
 */
public interface DownloadListener {

    void onSuccess(File file);

    boolean onError(NetErrorInfo netErrorInfo);

    void onFinal();
}
