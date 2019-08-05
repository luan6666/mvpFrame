package com.example.luan8.mvpframe.mvp.p;

import com.example.luan8.mvpframe.bean.BaseBean;
import com.example.luan8.mvpframe.bean.MainModel;
import com.example.luan8.mvpframe.bean.MessageBean;
import com.example.luan8.mvpframe.mvp.v.MainView;
import com.example.luan8.mvpframe.netUtils.RetrofitUtil;
import com.google.gson.Gson;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class MainPresenter extends MyPresenter<MainModel, MainView> {
    public void getData() {//这里要注意判空（view和model可能为空）
        if (model != null) {
            Observable<BaseBean<MessageBean>> observable = (Observable<BaseBean<MessageBean>>) model.getMessage();
            observable.observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<BaseBean<MessageBean>>() {
                @Override
                public void onSubscribe(Disposable d) {
                }

                @Override
                public void onNext(BaseBean<MessageBean> users) {
                    if (getView() != null) {
                        getView().setData(new Gson().toJson(users));
                    }
                }

                @Override
                public void onError(Throwable e) {
                }

                @Override
                public void onComplete() {
                }
            });
        }
    }


    @Override
    protected void onViewDestroy() {//销毁Activity时的操作，可以停止当前的model
        if (model != null) {
            model.stopRequest();
        }
    }
}
