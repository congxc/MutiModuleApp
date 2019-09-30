package com.shieh.mutilmoduleapp;

import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.shieh.modulearouter.FragmentRouterService;
import com.shieh.modulearouter.RouterUtils;
import com.shieh.modulebase.ui.activity.BaseActivity;

import androidx.annotation.NonNull;

public class MainActivity extends BaseActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.navigation_home:
                    setToolbarTitle(R.string.title_home);
                    RouterUtils.navigation(FragmentRouterService.PATH_FRAGMENT_HOME,R.id.fl_container,getSupportFragmentManager());
                    return true;
                case R.id.navigation_dashboard:
                    setToolbarTitle(R.string.title_dashboard);
                    RouterUtils.navigation(FragmentRouterService.PATH_FRAGMENT_DASHBOARD,R.id.fl_container,getSupportFragmentManager());
                    return true;
                case R.id.navigation_notifications:
                    setToolbarTitle(R.string.title_notifications);
                    RouterUtils.navigation(FragmentRouterService.PATH_FRAGMENT_NOTIFICATIONS,R.id.fl_container,getSupportFragmentManager());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected int getBottomViewLayoutId() {
        return R.layout.layout_bottom_nav_view;
    }

    @Override
    protected void initWidget() {
//        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_home_fragment);
//        mNavController = navHostFragment.getNavController();
        RouterUtils.navigation(FragmentRouterService.PATH_FRAGMENT_HOME,R.id.fl_container,getSupportFragmentManager());
        RouterUtils.navigation("/aaa/bbb");//全局异常降级

        //登录拦截器
//        Author author = new Author();
//                        author.setName("Margaret Mitchell");
//        author.setCounty("USA");
//        ARouter.getInstance().build(ActivityRouterService.PATH_ACTIVITY_LOGIN)
//                .withString("bookName", "Gone with the Wind")
//                .withObject("author", author)
//                .navigation(this, new NavigationCallback() {
//                    @Override
//                    public void onFound(Postcard postcard) {
//
//                    }
//
//                    @Override
//                    public void onLost(Postcard postcard) {
//
//                    }
//
//                    @Override
//                    public void onArrival(Postcard postcard) {
//
//                    }
//
//                    @Override
//                    public void onInterrupt(Postcard postcard) {
//                        Author author = new Author();
//                        author.setName("Margaret Mitchell");
//                        author.setCounty("USA");
//                        ARouter.getInstance().build(ActivityRouterService.PATH_ACTIVITY_ERROR)
//                                .withString("bookName", "Gone with the Wind")
//                                .withObject("author", author)
//                                .navigation();
//                    }
//                });

    }

    @Override
    protected void initBottomView(View bottomView) {
        BottomNavigationView navView = (BottomNavigationView) bottomView;
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
