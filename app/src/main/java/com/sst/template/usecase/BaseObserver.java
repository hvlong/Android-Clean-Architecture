package com.sst.template.usecase;

import com.sst.template.data.remote.network.NetworkError;

import io.reactivex.observers.DisposableSingleObserver;
import retrofit2.Response;

/**
 * @author LongHV.
 */

public abstract class BaseObserver<T> extends DisposableSingleObserver<retrofit2.Response<T>> {


    public abstract void onSuccessfulResponse(T response);
    public abstract void onFailure(NetworkError networkError);

    @Override
    public void onSuccess(Response<T> response) {
        if (response.isSuccessful()) {
            onSuccessfulResponse(response.body());
        } else {
            try {
                onFailure(new NetworkError(response));
            } catch (Exception e) {
                onFailure(new NetworkError(e));
            }
        }
    }

    @Override
    public void onError(Throwable e) {
        onFailure(new NetworkError(e));
    }
}
