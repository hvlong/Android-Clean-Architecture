package com.sst.template.view.base;

import android.support.annotation.StringRes;

/**
 * @author LongHV.
 */

public interface BaseView {

    void showLoading();
    void hideLoading();
    void onError(String message);
    void onError(@StringRes int resId);

}
