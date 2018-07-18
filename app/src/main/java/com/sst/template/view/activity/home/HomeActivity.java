package com.sst.template.view.activity.home;

import android.util.Log;

import com.sst.template.App;
import com.sst.template.R;
import com.sst.template.models.CityListResponse;
import com.sst.template.view.activity.BaseActivity;

import javax.inject.Inject;

public class HomeActivity extends BaseActivity implements HomeView {

    @Inject
    HomePresenter mPresenter;

    @Override
    protected void initializeDagger() {
        App app = (App)getApplicationContext();
        app.getNetWorkComponent().inject(this);
    }

    @Override
    protected void initializePresenter() {
        super.presenter = mPresenter;
        mPresenter.bindView(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initialize() {
        mPresenter.getCityListData();
    }

    @Override
    public void initializeCityList(CityListResponse cityListResponseList) {
        Log.d("longhv", "cityListResponseList" + cityListResponseList.getMessage());
    }

}
