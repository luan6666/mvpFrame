package com.example.luan8.mvpframe.mvp.p;

import com.example.luan8.mvpframe.mvp.m.BaseModel;
import com.example.luan8.mvpframe.mvp.v.BaseView;

import org.reactivestreams.Subscription;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public interface MyPresenter<V extends BaseView> {
    void add(Disposable disposable);
    void clear();

}
