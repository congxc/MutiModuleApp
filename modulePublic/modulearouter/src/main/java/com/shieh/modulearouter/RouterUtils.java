package com.shieh.modulearouter;

import android.app.Activity;
import android.util.Log;

import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/**
 * author: xiecong
 * create time: 2019/9/30 10:34
 * lastUpdate time: 2019/9/30 10:34
 */
public class RouterUtils implements FragmentRouterService, ActivityRouterService {

    public static void navigation(String path) {
        ARouter.getInstance().build(path).navigation();
    }

    public static void navigation(String path, Activity activity) {
        ARouter.getInstance().build(path).navigation(activity);
    }

    public static void navigation(String path, Activity activity, int requestCode) {
        ARouter.getInstance().build(path).navigation(activity, requestCode);
    }

    public static void navigation(String path, Activity activity, NavigationCallback callback) {
        ARouter.getInstance().build(path).navigation(activity, callback);
    }

    public static void navigation(String path, Activity activity, int requestCode, NavigationCallback callback) {
        ARouter.getInstance().build(path).navigation(activity, requestCode, callback);
    }

    public static void navigation(String path, int containerViewId, FragmentManager fragmentManager) {
        Fragment fragment = (Fragment) ARouter.getInstance().build(path).navigation();
        if (fragment != null) {
            fragmentManager.beginTransaction().replace(containerViewId, fragment).commit();
        } else {
            Log.e("navigation: ", "fragment is null");
        }
    }
}
