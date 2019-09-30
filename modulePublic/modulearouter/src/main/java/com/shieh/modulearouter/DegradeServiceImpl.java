package com.shieh.modulearouter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.DegradeService;

/**
 * 全局降级策略
 */
@Route(path = "/service/degrade")
public class DegradeServiceImpl implements DegradeService {

    private Context mContext;

    @Override
    public void onLost(Context context, Postcard postcard) {
        // do something.
        //比如页面一旦发生错误，未发现，则跳转到错误界面 此处Toast提示
        Log.e("DegradeServiceImpl", "page not found" + postcard.getPath());
        Toast.makeText(mContext, postcard.getPath() + " not found", Toast.LENGTH_LONG).show();
    }

    @Override
    public void init(Context context) {
        mContext = context;
    }
}