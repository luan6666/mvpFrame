package com.example.luan8.mvpframe.mvp;

import com.example.luan8.mvpframe.mvp.m.BaseModel;
import com.example.luan8.mvpframe.mvp.p.BasePresenter;
import com.example.luan8.mvpframe.mvp.p.MyPresenter;
import com.example.luan8.mvpframe.mvp.v.BaseView;

public interface BaseMvp <M extends BaseModel, V extends BaseView, P extends BasePresenter> {
    M createModel();

    V createView();

    P createPresenter();
}
