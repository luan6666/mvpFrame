package com.example.luan8.mvpframe;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.luan8.mvpframe.mvp.p.BasePresenter;

public abstract class BaseActivity<P extends BasePresenter> extends Activity {
     protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initContentView());
        initData();
    }

    protected abstract void initData();


    private int initContentView() {
        return 0;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.clear();
    }
}
