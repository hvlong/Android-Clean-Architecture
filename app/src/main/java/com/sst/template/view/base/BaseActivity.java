package com.sst.template.view.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.sst.template.utils.CommonUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author LongHV.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    public BasePresenter basePresenter;
    private Unbinder mUnbinder;
    private ProgressDialog mProgressDialog;

    protected abstract void initializeDagger();
    protected abstract void initializePresenter();
    public abstract int getLayoutId();
    public abstract void initialize();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mUnbinder = ButterKnife.bind(this);
        initializeDagger();
        initializePresenter();
        initialize();
    }

    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this);
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onError(int resId) {
        onError(getString(resId));
    }

    /**
     * Adds a {@link Fragment} to this activity's layout.
     *
     * @param containerViewId The container view to where add the fragment.
     * @param fragment The fragment to be added.
     */
    protected void addFragment(int containerViewId, Fragment fragment) {
        final FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
        if (basePresenter != null) {
            basePresenter.unSubscribe();
            basePresenter.unBindView();
            basePresenter = null;
        }
    }
}
