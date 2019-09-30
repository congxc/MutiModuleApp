package com.shieh.modulearouter;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * author: xiecong
 * create time: 2019/9/29 19:30
 * lastUpdate time: 2019/9/29 19:30
 */
public class BaseApplication extends Application {

    public static final boolean isDebug = true;
    @Override
    public void onCreate() {
        super.onCreate();
        if (isDebug) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }
}
