package com.sst.template.data.remote;

import com.sst.template.data.remote.network.NetworkService;
import com.sst.template.models.Movie;
import com.sst.template.models.MovieListResponse;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Response;

/**
 * @author LongHV.
 */

public class RemoteRepository implements RemoteSource{

//    private ApiService mApiService;
    private NetworkService networkService;

    @Inject
    RemoteRepository(NetworkService networkService) {
//        this.mApiService = mApiService;
        this.networkService = networkService;
    }

    @Override
    public Single<Response<MovieListResponse>> getMovieList(int year) {
        return networkService.getMovieList();
    }

    @Override
    public Single<Response<Movie>> getMovieDetail(int id) {
        return networkService.getDetailMovie(id);
    }

}
