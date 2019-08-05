package com.example.luan8.mvpframe.bean;

import com.example.luan8.mvpframe.mvp.m.BaseModel;

import io.reactivex.Observable;


public interface MainModel extends BaseModel {
    Observable<BaseBean<MessageBean>> getMainData();
    Object getMessage();
    void stopRequest();

}
