package com.shieh.modulearouter;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * 用于自定义对象传递，无需建立关系，直接传递自定义对象即可
 */
@Route(path = "/service/json")
public class JsonServiceImpl implements SerializationService {

    @Override
    public void init(Context context) {

    }

    @Override
    public <T> T json2Object(String text, Class<T> clazz) {
//        JSON.parseObject(text, clazz);
        return new Gson().fromJson(text,clazz);
    }

    @Override
    public String object2Json(Object instance) {
//        return JSON.toJSONString(instance);
        return new Gson().toJson(instance);
    }

    @Override
    public <T> T parseObject(String input, Type clazz) {
//        return JSON.parseObject(input, clazz);
        return new Gson().fromJson(input,clazz);
    }
}
