package com.example.luan8.mvpframe.mvp.p;

import com.example.luan8.mvpframe.mvp.v.BaseView;

import org.reactivestreams.Subscriber;

import java.util.Observable;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter implements MyPresenter {
    private CompositeDisposable disposables;
    @Override
    public void add(Disposable disposable) {
        if(null == disposable){
            disposables = new CompositeDisposable();

        }
        disposables.add(disposable);
    }

    @Override
    public void clear() {
        if(null != disposables&&disposables.isDisposed()){
            disposables.clear();
        }
    }
}
