package com.sst.template.base;

import java.lang.ref.WeakReference;

/**
 * @author LongHV.
 */

public abstract class BasePresenter<T extends BaseView> {

    public abstract void unSubscribe();
    private WeakReference<T> view;

    public T getView() {
        return view.get();
    }

    public void bindView(T view) {
        this.view = new WeakReference<>(view);
    }

    public void unBindView() {
        if (view != null) {
            view.clear();
            view = null;
        }
    }

}
