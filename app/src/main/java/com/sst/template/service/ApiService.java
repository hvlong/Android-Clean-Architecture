package com.sst.template.service;


import com.sst.template.models.CityListResponse;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Response;


/**
 * @author LongHV.
 */

public class ApiService {

    private NetworkService networkService;

    @Inject
    public ApiService(NetworkService networkService) {
        this.networkService = networkService;
    }

    public Single<Response<CityListResponse>> getCityList() {
        return networkService.getCityList();
    }

}
