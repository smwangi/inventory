package com.samwan.inventory.data.remote;

import com.samwan.inventory.data.remote.ApiConstants;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by smwangi on 1/22/18.
 */

public class RequestInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originaRequest = chain.request();
        HttpUrl originalHttpUrl = originaRequest.url();

        HttpUrl url = originalHttpUrl.newBuilder().addQueryParameter("api_ke", ApiConstants.API_KEY).build();

        Request request  = originaRequest.newBuilder().url(url).build();
        return chain.proceed(request);
    }
}
