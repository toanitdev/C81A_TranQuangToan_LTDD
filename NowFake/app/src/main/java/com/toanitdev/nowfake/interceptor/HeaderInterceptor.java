package com.toanitdev.nowfake.interceptor;

import android.os.Build;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request original = chain.request();

        String userAgent =
                "Example Application/1.0.0 (Android " + Build.VERSION.RELEASE + ")";
        Request request = original.newBuilder()
                .header("User-Agent", userAgent)
                .method(original.method(), original.body())
                .build();
        return chain.proceed(request);
    }
}