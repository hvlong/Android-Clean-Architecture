package com.sst.template.view.activity.detail;

import com.sst.template.App;
import com.sst.template.R;
import com.sst.template.view.base.BaseActivity;
import com.sst.template.view.fragment.detail.DetailFragment;

public class DetailActivity extends BaseActivity {

    @Override
    protected void initializeDagger() {
        App app = (App)getApplicationContext();
        app.getNetWorkComponent().inject(this);
    }

    @Override
    protected void initializePresenter() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_detail;
    }

    @Override
    public void initialize() {
        addFragment(R.id.flDetailContainer, new DetailFragment());
    }

}
