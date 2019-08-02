package com.example.luan8.mvpframe.netUtils;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Nullable;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class FastjsonConverterFactory extends Converter.Factory {
    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {

        if (type == Object.class) {
            return new MyBodyConverter<Type>();
        }
        //如果返回null则不处理，交给别的Converter处理
        return null;
    }
    private static class MyBodyConverter<T> implements Converter<ResponseBody, T> {
        MyBodyConverter() {
        }
        //在这个方法中处理response
        @Override
        public T convert(ResponseBody value) throws IOException {
            String body = value.string();

            return (T) ResponseUtil.MyResponse(body);

        }
    }
}
