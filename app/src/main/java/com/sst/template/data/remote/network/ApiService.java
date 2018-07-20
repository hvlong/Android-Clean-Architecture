package com.sst.template.data.remote.network;

import com.sst.template.models.MovieListResponse;

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

    public Single<Response<MovieListResponse>> getMovieList(int year) {
        return networkService.getMovieList();
    }

}
