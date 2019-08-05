package com.example.luan8.mvpframe.mvp.p;

import com.example.luan8.mvpframe.mvp.m.BaseModel;
import com.example.luan8.mvpframe.mvp.v.BaseView;

import java.lang.ref.WeakReference;


public abstract class MyPresenter<M extends BaseModel, V extends BaseView> implements BasePresenter<M, V>  {
    /**
     * 使用弱引用来防止内存泄漏
     */
    private WeakReference<V> wrf;
    protected M model;

    @Override
    public void registerModel(M model) {
        this.model = model;
    }

    @Override
    public void registerView(V view) {
        wrf = new WeakReference<V>(view);
    }

    @Override
    public V getView() {
        return wrf == null ? null : wrf.get();
    }

    /**
     * 在Activity或Fragment卸载时调用View结束的方法
     */
    @Override
    public void destroy() {
        if (wrf != null) {
            wrf.clear();
            wrf = null;
        }
        onViewDestroy();
    }

    protected abstract void onViewDestroy();

}
