package com.sst.template.view.base;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.sst.template.R;
import com.sst.template.data.remote.network.NetworkError;
import com.sst.template.data.remote.network.BodyErrorResponse;

import java.io.IOException;
import java.lang.ref.WeakReference;

import retrofit2.adapter.rxjava.HttpException;

/**
 * @author LongHV.
 */
public abstract class BasePresenter<T extends BaseView> implements Presenter{

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

    @Override
    public void handleApiError(NetworkError networkError) {
        if (networkError != null && networkError.response != null) {
//            switch (networkError.response.code()) {
//                case HttpsURLConnection.HTTP_UNAUTHORIZED:
//                case HttpsURLConnection.HTTP_FORBIDDEN:
////                    setUserAsLoggedOut();
////                    getMvpView().openActivityOnTokenExpire();
//                case HttpsURLConnection.HTTP_INTERNAL_ERROR:
//                case HttpsURLConnection.HTTP_NOT_FOUND:
//                default:
////                    getMvpView().onError(networkError.getMessage());
//            }
                String message = getJsonStringFromResponse(networkError.response);
                if (!TextUtils.isEmpty(message)) {
                    getView().onError(message);
                } else {
                    getView().onError(R.string.api_default_error);
                }
        } else if (networkError != null && networkError.throwable != null) {
            if (networkError.throwable instanceof IOException) {
                getView().onError(R.string.no_internet_connection);
            } else if (!(networkError.throwable instanceof HttpException)) {
                getView().onError(R.string.some_error);
            }
        } else {
            getView().onError(R.string.some_error);
        }
    }

    private String getJsonStringFromResponse(final retrofit2.Response<?> response) {
        try {
            String jsonString = response.errorBody().string();
            BodyErrorResponse errorResponse = new Gson().fromJson(jsonString, BodyErrorResponse.class);
            return errorResponse.message;
        } catch (Exception e) {
            return null;
        }
    }
}
