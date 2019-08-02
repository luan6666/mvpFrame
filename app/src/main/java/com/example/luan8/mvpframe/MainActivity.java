package com.example.luan8.mvpframe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.luan8.mvpframe.mvp.p.MessagePresenter;
import com.example.luan8.mvpframe.mvp.v.SendMessageView;

public class MainActivity extends BaseActivity<MessagePresenter> implements SendMessageView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
