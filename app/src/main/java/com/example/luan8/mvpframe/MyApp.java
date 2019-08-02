package com.example.luan8.mvpframe;

import android.app.Application;
import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MyApp extends Application {
    public static MyApp myApp;
    private static OkHttpClient okHttpClient;

    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
    }



}
