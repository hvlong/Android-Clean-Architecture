package com.sst.template.data;

import com.sst.template.models.CityListResponse;

import io.reactivex.Single;
import retrofit2.Response;


/**
 * @author LongHV.
 */
public interface DataSource {
    Single<Response<CityListResponse>> requestCityList();
}
