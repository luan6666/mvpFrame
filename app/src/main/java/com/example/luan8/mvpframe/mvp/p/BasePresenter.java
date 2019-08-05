package com.example.luan8.mvpframe.mvp.p;

import com.example.luan8.mvpframe.mvp.m.BaseModel;
import com.example.luan8.mvpframe.mvp.v.BaseView;


public interface BasePresenter<M extends BaseModel, V extends BaseView> {
    /**
     * 注册Model层
     *
     * @param model
     */
    void registerModel(M model);

    /**
     * 注册View层
     *
     * @param view
     */
    void registerView(V view);

    /**
     * 获取View
     *
     * @return
     */
    V getView();

    /**
     * 销毁动作（如Activity、Fragment的卸载）
     */
    void destroy();
}
