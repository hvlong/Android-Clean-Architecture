package com.sst.template.data.remote;

import com.sst.template.models.CityListResponse;

import io.reactivex.Single;
import retrofit2.Response;

/**
 * @author LongHV.
 */
interface RemoteSource {
    Single<Response<CityListResponse>> getNews();
}