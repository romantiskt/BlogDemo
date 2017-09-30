package com.wang.advance.net;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by wangyang on 2017/9/30.
 */

public interface CommonApis {
    @GET
    Observable<ResponseBody> getBaidu(@Url String url);
}
