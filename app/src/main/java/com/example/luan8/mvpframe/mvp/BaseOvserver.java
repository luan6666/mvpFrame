package com.example.luan8.mvpframe.mvp;

import android.content.Context;

import io.reactivex.disposables.Disposable;


public abstract class BaseOvserver<T> implements io.reactivex.Observer<T> {
    private Context context;

    public BaseOvserver(Context context) {
        this.context = context;
    }

    @Override
    public void onSubscribe(Disposable d) {
        onDisposaable(d);
    }

    @Override
    public void onNext(T t) {
            onSuccess(t);
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable e) {

    }
    protected abstract void onSuccess(T t);
    protected abstract void onDisposaable(Disposable d);
}
