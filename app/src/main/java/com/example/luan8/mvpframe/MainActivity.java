package com.example.luan8.mvpframe;

import android.os.Bundle;

import com.example.luan8.mvpframe.bean.MessageBean;
import com.example.luan8.mvpframe.mvp.p.MainPresenter;
import com.example.luan8.mvpframe.mvp.v.MainView;

public class MainActivity extends BaseActivity<MessageBean,MainView,MainPresenter> implements MainView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public MessageBean createModel() {
        return null;
    }

    @Override
    public MainView createView() {
        return null;
    }

    @Override
    public MainPresenter createPresenter() {
        return null;
    }

    @Override
    public void setData() {

    }
}
