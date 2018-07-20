package com.sst.template.data;

import com.sst.template.models.Movie;
import com.sst.template.models.MovieListResponse;

import io.reactivex.Single;
import retrofit2.Response;

/**
 * @author LongHV.
 */
public interface DataSource {

    Single<Response<MovieListResponse>> requestMovieList(int year);
    Single<Response<Movie>> requestMovieDetail(int id);

}
