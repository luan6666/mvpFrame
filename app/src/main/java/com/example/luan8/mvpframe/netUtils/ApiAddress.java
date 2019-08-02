package com.example.luan8.mvpframe.netUtils;

import com.example.luan8.mvpframe.bean.BaseBean;
import com.example.luan8.mvpframe.bean.MessageBean;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiAddress {
    public static final String BASEUEL= "";

    @POST("")
    Observable<BaseBean<MessageBean>> getData(@Query("path")String paht);
}
