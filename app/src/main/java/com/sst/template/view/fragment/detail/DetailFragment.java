package com.sst.template.view.fragment.detail;


import android.support.v4.app.Fragment;
import android.util.Log;

import com.sst.template.App;
import com.sst.template.R;
import com.sst.template.models.Movie;
import com.sst.template.view.base.BaseFragment;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends BaseFragment implements DetailContract.View {

    @Inject
    DetailPresenter mDetailPresenter;

    public DetailFragment() {
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_detail;
    }

    @Override
    protected void initializeDagger() {
        App app = (App)getActivity().getApplicationContext();
        app.getNetWorkComponent().inject(this);
    }

    @Override
    protected void initializePresenter() {
        super.basePresenter = mDetailPresenter;
        mDetailPresenter.bindView(this);
    }

    @Override
    public void initialize() {
        mDetailPresenter.getMovieDetail(363088);
    }

    @Override
    public void initializeMovieDetail(Movie movie) {
        Log.d("longhv", "---" + movie.title);
    }
}
