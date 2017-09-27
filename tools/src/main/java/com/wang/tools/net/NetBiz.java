
package com.wang.tools.net;

import android.content.Context;
import android.text.TextUtils;

import com.wang.tools.common.GsonUtil;
import com.wang.tools.common.LogUtils;
import com.wang.tools.common.StringUtils;
import com.basenet.net.OkHttpUtils;
import com.basenet.net.builder.PostFormBuilder;

import java.io.File;
import java.util.Map;
import java.util.Set;

/**
 * 网络请求库.
 */
public class NetBiz {

    /**
     * 发送一个Post网络请求.
     * <p>body只能是string,string
     */
    public <T extends BaseResponse> void sendRequest(final BaseRequest request, final Class<T> responseClazz, final NetListener<T> netListener) {

        if (StringUtils.isEmpty(request.getUrl())) {
            throw new NullPointerException("Http Url can not be null !!!");
        } else if (request.getRequestMap() == null) {
            throw new NullPointerException("Request Map can not be null !!!");
        } else if (StringUtils.isEmpty(request.getTag())) {
            throw new NullPointerException("Tag can not be null !!!");
        }
        final String params = GsonUtil.GsonString(request.getRequestMap());
        final String token = request.getToken();
        String url = null;
        if (TextUtils.isEmpty(token)) {
            url = request.getUrl();
        } else {
            url = request.getUrl() + "?token=" + token;
        }
        LogUtils.n("请求信息_____" + url + "__参数__" + params);
        OkHttpUtils
                .postString()
                .tag(request.getTag())
                .url(url)
                .content(params)
                .build()
                .execute(new BaseCallback<T>(request, responseClazz, netListener));
    }

    /**
     * 上传多个文件的网络请求
     */
    public <T extends BaseResponse> void uploadFiles(final Context context, UploadFileRequest request, final Class<T> responseClazz, final NetListener<T> netListener) {

        if (StringUtils.isEmpty(request.getUrl())) {
            throw new NullPointerException("Http Url can not be null !!!");
        } else if (request.getRequestMap() == null) {
            throw new NullPointerException("Request Map can not be null !!!");
        } else if (StringUtils.isEmpty(request.getTag())) {
            throw new NullPointerException("Tag can not be null !!!");
        }

        Map<String, File> files = request.getUploadFiles();

        PostFormBuilder post = OkHttpUtils.post();
        if (files != null && files.size() != 0) {
            Set<String> keys = files.keySet();
            // 上传多个文件
            for (String key : keys) {
                File file = files.get(key);
                if (file.exists()) {
                    post.addFile(key, file.getName(), file);
                } else {
                    // 是否需要处理文件不存在的情况
                    // throw new FileNotFoundException("要上传的文件 : " + file.getAbsolutePath() + "不存在");
                }
            }
        }

        post.url(request.getUrl())
                .tag(request.getTag())
                .params(request.getRequestMap())
                .build()
                .execute(new BaseCallback<T>(request, responseClazz, netListener));

    }

    /**
     * 下载文件
     *
     * @param request  请求
     * @param dir      下载文件保存的目录
     * @param fileName 下载文件保存的文件名
     */
    public void downloadFile(BaseRequest request, String dir, String fileName, DownloadListener listener) {
        if (StringUtils.isEmpty(request.getUrl())) {
            throw new NullPointerException("Http Url can not be null !!!");
        } else if (StringUtils.isEmpty(request.getTag())) {
            throw new NullPointerException("Tag can not be null !!!");
        }

        OkHttpUtils
                .get()
                .tag(request.getTag())
                .url(request.getUrl())
                .build()
                .execute(new BaseFileCallBack(request, dir, fileName, listener));
    }

    /**
     * 取消请求
     */
    public static void cancelRequest(String tag) {
        OkHttpUtils.getInstance().cancelTag(tag);
    }
}
