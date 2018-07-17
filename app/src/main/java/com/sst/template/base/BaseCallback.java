package com.sst.template.base;

/**
 * @author LongHV.
 */
public interface BaseCallback<T> {

    void onSuccess(T response);

    void onFail();
}
