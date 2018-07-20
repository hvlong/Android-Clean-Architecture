package com.sst.template.view.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sst.template.utils.CommonUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author LongHV.
 */

public abstract class BaseFragment extends Fragment implements BaseView {

    public BasePresenter basePresenter;
    private ProgressDialog mProgressDialog;
    private Unbinder mUnbinder;

    public abstract int getLayoutId();
    protected abstract void initializeDagger();
    protected abstract void initializePresenter();
    public abstract void initialize();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        mUnbinder = ButterKnife.bind(this, view);
        initializeDagger();
        initializePresenter();
        initialize();
        return view;
    }

    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(getActivity());
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

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
        if (basePresenter != null) {
            basePresenter.unBindView();
            basePresenter.unSubscribe();
            basePresenter = null;
        }
    }
}
