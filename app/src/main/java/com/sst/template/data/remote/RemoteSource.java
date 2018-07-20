package com.sst.template.data.remote;

import com.sst.template.models.Movie;
import com.sst.template.models.MovieListResponse;

import io.reactivex.Single;
import retrofit2.Response;

/**
 * @author LongHV.
 */
interface RemoteSource {

    Single<Response<MovieListResponse>> getMovieList(int year);
    Single<Response<Movie>> getMovieDetail(int id);

}
