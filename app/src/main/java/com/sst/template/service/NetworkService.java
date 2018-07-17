package com.sst.template.service;


import com.sst.template.models.CityListResponse;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;

public interface NetworkService {

    @GET("v1/city")
    Single<Response<CityListResponse>> getCityList();

}
