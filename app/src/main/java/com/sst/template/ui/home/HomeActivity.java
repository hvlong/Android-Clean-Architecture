package com.sst.template.ui.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.sst.template.App;
import com.sst.template.R;
import com.sst.template.models.CityListResponse;

import javax.inject.Inject;

public class HomeActivity extends AppCompatActivity implements HomeView{

//    @Inject
//    public ApiService mApiService;

    @Inject
    HomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App)getApplication()).getNetWorkComponent().inject(this);
//        HomePresenter homePresenter = new HomePresenter(mApiService, this);
//        homePresenter.getCityList();
        presenter.getCityListData();
    }

    @Override
    public void showWait() {
        Log.d("HomeActivity", "showWait");
    }

    @Override
    public void removeWait() {
        Log.d("HomeActivity", "removeWait");
    }

    @Override
    public void onFailure(String appErrorMessage) {
        Log.d("HomeActivity", "onError");
    }

    @Override
    public void getCityListSuccess(CityListResponse cityListResponse) {
        Log.d("HomeActivity", cityListResponse.getData().size() + "----");
    }
}
