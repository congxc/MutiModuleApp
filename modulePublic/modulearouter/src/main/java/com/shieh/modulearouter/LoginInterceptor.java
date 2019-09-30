package com.shieh.modulearouter;

import android.content.Context;
import android.text.TextUtils;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

/**
 * 跳转到登录界面的拦截器，如果未登录正常跳转，否者拦截
 */
@Interceptor(priority = 1, name = "login interceptor")
public class LoginInterceptor implements IInterceptor {

    public static boolean isLogin = false;

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        if (TextUtils.equals(ActivityRouterService.PATH_ACTIVITY_LOGIN, postcard.getPath())) {
            if (isLogin) {
                callback.onInterrupt(new RuntimeException("isLogin"));
            } else {
                callback.onContinue(postcard);
            }
        }else{
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {

    }
}
