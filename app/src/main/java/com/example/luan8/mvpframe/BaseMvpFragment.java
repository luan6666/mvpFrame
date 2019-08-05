package com.example.luan8.mvpframe;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.example.luan8.mvpframe.mvp.BaseMvp;
import com.example.luan8.mvpframe.mvp.m.BaseModel;
import com.example.luan8.mvpframe.mvp.p.BasePresenter;
import com.example.luan8.mvpframe.mvp.v.BaseView;

public abstract class BaseMvpFragment<M extends BaseModel, V extends BaseView, P extends BasePresenter> extends Fragment implements BaseMvp<M, V, P> {

    protected P presenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        presenter = createPresenter();
        if (presenter != null) {
            presenter.registerModel(createModel());
            presenter.registerView(createView());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (presenter != null) {
            presenter.destroy();
        }
    }

}
