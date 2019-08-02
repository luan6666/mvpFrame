package com.example.luan8.mvpframe.mvp.m;


import com.example.luan8.mvpframe.bean.BaseBean;
import com.example.luan8.mvpframe.bean.MessageBean;
import com.example.luan8.mvpframe.netUtils.ApiAddress;
import com.example.luan8.mvpframe.netUtils.RetrofitUtil;

import io.reactivex.Observable;

public class MessageModel extends BaseModel {

    public Observable<BaseBean<MessageBean>> getMessageInfo() {
        return observable(RetrofitUtil.getInstance().create(ApiAddress.class, ApiAddress.BASEUEL).getData(""));
    }
}
