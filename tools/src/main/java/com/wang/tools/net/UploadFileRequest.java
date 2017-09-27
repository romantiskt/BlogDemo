package com.wang.tools.net;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 上传文件的请求.
 */
public class UploadFileRequest extends BaseRequest {

    /**
     * 需要上传的文件的集合
     * <p>key:post表单字段的名称;value:File对象
     */
    private Map<String, File> uploadFiles = new LinkedHashMap<>();

    public Map<String, File> getUploadFiles() {
        return uploadFiles;
    }

    public void setUploadFiles(Map<String, File> uploadFiles) {
        this.uploadFiles = uploadFiles;
    }

    /**
     * 添加一个文件
     */
    public void addUploadFile(String key, File file) {
        uploadFiles.put(key, file);
    }
}
