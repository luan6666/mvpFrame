package com.example.luan8.mvpframe.netUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.luan8.mvpframe.bean.BaseBean;

class ResponseUtil {
    public static Object MyResponse(String body) {
        BaseBean baseBean = JSONObject.parseObject(body,BaseBean.class);
        return baseBean;
    }
}
