package com.example.luan8.mvpframe.netUtils;

import android.arch.lifecycle.LiveData;

import com.example.luan8.mvpframe.bean.BaseBean;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveDataCallAdapter<R> implements CallAdapter<R, LiveData<BaseBean>> {
    private final Type responseType;

    public LiveDataCallAdapter(Type responseType) {
        this.responseType = responseType;
    }

    @Override
    public Type responseType() {
        return responseType;
    }

    @Override
    public LiveData<BaseBean> adapt(final Call<R> call) {
        return new LiveData<BaseBean>() {
            AtomicBoolean started = new AtomicBoolean(false);

            @Override
            protected void onActive() {
                super.onActive();
                if (started.compareAndSet(false, true)) {
                    call.enqueue(new Callback<R>() {
                        @Override
                        public void onResponse(Call<R> call, Response<R> response) {
                            BaseBean responseData = new BaseBean<>();
                            if (response.isSuccessful()) {
                                responseData = (BaseBean) response.body();
                            } else {
                                responseData.setCode(response.code());
                            }
                            postValue(responseData);
                        }

                        @Override
                        public void onFailure(Call<R> call, Throwable throwable) {
                            BaseBean responseData = new BaseBean<>();
                            responseData.setCode(500);
                            responseData.setData(null);
                            responseData.setMessage(throwable.getMessage());
                            postValue(responseData);
                        }
                    });
                }
            }
        };
    }
}