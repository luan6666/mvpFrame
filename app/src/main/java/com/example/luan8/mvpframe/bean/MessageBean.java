package com.example.luan8.mvpframe.bean;


import io.reactivex.Observable;
import io.reactivex.internal.schedulers.IoScheduler;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MessageBean implements MainModel {

    interface getMessageService {

        @GET("IASNDIANSD")
        Observable<BaseBean<MessageBean>> getMessageList ;
    }

    @Override
    public Observable<BaseBean<MessageBean>> getMainData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.icandemy.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(new IoScheduler()))
                .build();
        getMessageService gitHubService = retrofit.create(getMessageService.class);
        return getMessageService.getMessageList();
    }

    @Override
    public Object getMessage() {
        return "";
    }

    @Override
    public void stopRequest() {

    }

}
