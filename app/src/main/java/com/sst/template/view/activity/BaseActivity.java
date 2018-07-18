package com.sst.template.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.sst.template.base.BasePresenter;
import com.sst.template.base.BaseView;

/**
 * @author LongHV.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    public BasePresenter presenter;

    protected abstract void initializeDagger();
    protected abstract void initializePresenter();
    public abstract int getLayoutId();
    public abstract void initialize();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initializeDagger();
        initializePresenter();
        initialize();
    }

    @Override
    public void onShowLoading() {

    }

    @Override
    public void onHideLoading() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.unSubscribe();
            presenter.unBindView();
            presenter = null;
        }

    }
}
