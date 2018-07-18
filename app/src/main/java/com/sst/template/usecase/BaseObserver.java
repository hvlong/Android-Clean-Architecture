package com.sst.template.usecase;

import com.sst.template.service.NetworkError;

import io.reactivex.observers.DisposableSingleObserver;
import retrofit2.Response;

/**
 * @author LongHV.
 */

public abstract class BaseObserver<T> extends DisposableSingleObserver<retrofit2.Response<T>> {


    public abstract void onSuccessfulResponse(T response);
    public abstract void onFailure(NetworkError error);

    @Override
    public void onSuccess(Response<T> response) {
        if (response.isSuccessful()) {
            onSuccessfulResponse(response.body());
        }
//        else {
//            try {
//                Gson gson = new Gson();
//                ErrorDto errorDto =gson.fromJson(response.errorBody().charStream(),ErrorDto.class);
//                onError(errorDto);
//            } catch (Exception e) {
//                ErrorDto errorDto = new ErrorDto();
//                errorDto.setMessage("エラーが発生しました。再度お試しください。");
//                onError(errorDto);
//            }
//        }
    }

    @Override
    public void onError(Throwable e) {
        onFailure(new NetworkError(e));
    }
}
