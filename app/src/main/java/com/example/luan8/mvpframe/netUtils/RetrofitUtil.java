package com.example.luan8.mvpframe.netUtils;

import android.util.Log;

import com.example.luan8.mvpframe.MyApp;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

public class RetrofitUtil {
    private static volatile RetrofitUtil newInstance;
    public static final int TIMEOUT = 60;


    public static RetrofitUtil getInstance() {
        if (newInstance == null) {
            synchronized (RetrofitUtil.class) {
                if (newInstance == null) {
                    newInstance = new RetrofitUtil();
                }
            }
        }
        return newInstance;
    }

    public <S> S create(Class<S> service, String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(initClient())
                .baseUrl(baseUrl)
                .addConverterFactory(new FastjsonConverterFactory())
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .build();
        return retrofit.create(service);
    }

    private OkHttpClient initClient() {
        return new OkHttpClient.Builder()
                .proxy(Proxy.NO_PROXY)
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(new LoggingInterceptor())
                .build();

    }

    static class LoggingInterceptor implements Interceptor {

        @NotNull
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Long systemTime = System.nanoTime();
            Log.i("", String.format("Sending request %s in %.1fms%n#s", request.url(), chain.connection(), request.headers()));
            Response response = chain.proceed(request);


            return response;
        }
    }
}
