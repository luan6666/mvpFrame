package com.example.luan8.mvpframe;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.luan8.mvpframe.mvp.BaseMvp;
import com.example.luan8.mvpframe.mvp.m.BaseModel;
import com.example.luan8.mvpframe.mvp.p.BasePresenter;
import com.example.luan8.mvpframe.mvp.v.BaseView;

public abstract class BaseActivity<M extends BaseModel, V extends BaseView, P extends BasePresenter>
        extends AppCompatActivity implements BaseMvp<M, V, P> {
    protected P presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //创建Presenter
        presenter = createPresenter();
        if (presenter != null) {
            //将Model层注册到Presenter中
            presenter.registerModel(createModel());
            //将View层注册到Presenter中
            presenter.registerView(createView());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            //Activity销毁时的调用，让具体实现BasePresenter中onViewDestroy()方法做出决定
            presenter.destroy();
        }
    }
}
