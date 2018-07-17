package com.sst.template.data.local;

import com.sst.template.models.CityListResponse;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import retrofit2.Response;

/**
 * @author LongHV.
 */

public class LocalRepository {
    @Inject
    public LocalRepository() {
    }

    public Single<retrofit2.Response<CityListResponse>> getNews() {
        return Single.create(new SingleOnSubscribe<Response<CityListResponse>>() {
            @Override
            public void subscribe(SingleEmitter<Response<CityListResponse>> e) throws Exception {
                CityListResponse cityListResponse = new CityListResponse();
                cityListResponse.setData(null);
                cityListResponse.setStatus(100);
                cityListResponse.setMessage("Successful");
                Response<CityListResponse> response = Response.success(cityListResponse);
                e.onSuccess(response);
            }
        });
    }
}
