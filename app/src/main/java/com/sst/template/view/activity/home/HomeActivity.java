package com.sst.template.view.activity.home;

import android.util.Log;

import com.sst.template.App;
import com.sst.template.R;
import com.sst.template.models.MovieListResponse;
import com.sst.template.view.base.BaseActivity;

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
        super.mPresenter = mPresenter;
        mPresenter.bindView(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initialize() {
        mPresenter.getMovieListData();
    }

    @Override
    public void initializeMovieList(MovieListResponse movieListResponse) {
        Log.d("longhv", "cityListResponseList" + movieListResponse.movieList.size());
    }
}
