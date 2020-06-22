package com.toanitdev.nowfake.rest_adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.toanitdev.nowfake.Constant;
import com.toanitdev.nowfake.interceptor.HeaderInterceptor;
import com.toanitdev.nowfake.interceptor.HttpLoggingInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RestAdapter {
    public static Retrofit create(){
        //set mac dinh cho Retrofit
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        okHttpBuilder.readTimeout(3, TimeUnit.MINUTES);
        okHttpBuilder.writeTimeout(3, TimeUnit.MINUTES);
        okHttpBuilder.connectTimeout(3, TimeUnit.MINUTES);


        //Tao logging debug
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpBuilder.addInterceptor(httpLoggingInterceptor);

        //Tao header cho logging
        okHttpBuilder.addInterceptor(new HeaderInterceptor());


        GsonBuilder gsonBuilder = new GsonBuilder();

        Gson gson =
                gsonBuilder.setLenient().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").serializeNulls().create();


        return new Retrofit.Builder().baseUrl(Constant.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpBuilder.build())
                .build();
    }
}
