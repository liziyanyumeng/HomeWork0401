package com.bawei.liziyan20200401.util;

import android.text.TextUtils;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
    private static RetrofitUtil instance;
    private static String baseUrl = "http://mobile.bwstudent.com/small/";
    private final Retrofit retrofit;

    private RetrofitUtil() {
        final HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        final OkHttpClient builder = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(new Interceptor() {
                    @NotNull
                    @Override
                    public Response intercept(@NotNull Chain chain) throws IOException {
                        final Request request = chain.request();
                        final Request.Builder builder1 = request.newBuilder();
                        final String sessionId = SpUtil.getString("sessionId");
                        final int userId = SpUtil.getInt("userId");
                        //判断
                        if (!TextUtils.isEmpty(sessionId)){
                            builder1.addHeader("sessionId",sessionId);
                        }
                        if (userId!=-1){
                            builder1.addHeader("userId",userId+"");
                        }
                        final Request build = builder1.build();
                        return chain.proceed(build);
                    }
                })
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(builder)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetrofitUtil getInstance() {
        if (instance==null) {
            instance = new RetrofitUtil();
        }
        return instance;
    }

    public ApiService apiService(){
        final ApiService apiService = retrofit.create(ApiService.class);
        return apiService;
    }
}
