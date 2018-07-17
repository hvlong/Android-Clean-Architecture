package com.sst.template.data.remote;

import com.sst.template.models.CityListResponse;
import com.sst.template.service.ApiService;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Response;

/**
 * @author LongHV.
 */

public class RemoteRepository implements RemoteSource{

    private ApiService mApiService;

    @Inject
    public RemoteRepository(ApiService mApiService) {
        this.mApiService = mApiService;
    }

    @Override
    public Single<Response<CityListResponse>> getNews() {
        return mApiService.getCityList();
    }
}
