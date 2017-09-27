
package com.wang.tools.net;


/**
 * 网络加载数据回掉的接口.
 */
public interface NetListener<T extends BaseResponse> {

    /**
     * 网络数据加载成功
     */
    public void onSuccess(T t);

    /**
     * 网络错误导致加载失败的回掉
     *
     * @param netErrorInfo 网络错误信息
     * @return 是否显示网络错误的Toast提示
     */
    public boolean onError(NetErrorInfo netErrorInfo);

    /**
     * 业务错误导致加载失败的回掉
     *
     * @param bizErrorInfo 业务错误信息
     * @return 是否显示业务错误的Toast提示
     */
    public boolean onFailed(BizErrorInfo bizErrorInfo);

    /**
     * 接口访问完成的回掉
     */
    public void onFinal();

}
