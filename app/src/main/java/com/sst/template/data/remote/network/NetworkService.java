package com.sst.template.data.remote.network;

import com.sst.template.models.Movie;
import com.sst.template.models.MovieListResponse;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface NetworkService {

    String GET_MOVIE_LIST = "movie/popular?api_key=2483d809cdbf68efa302d4729ad37e38";

    @GET(GET_MOVIE_LIST)
    Single<Response<MovieListResponse>> getMovieList();

    @GET("movie/{movie_id}?api_key=2483d809cdbf68efa302d4729ad37e38")
    Single<Response<Movie>> getDetailMovie(@Path("movie_id") int movieId);



}
