package com.sst.template.data.local;

import com.sst.template.models.MovieListResponse;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import retrofit2.Response;

/**
 * @author LongHV.
 */

public class LocalRepository {
    @Inject
    public LocalRepository() {
    }

    public Single<retrofit2.Response<MovieListResponse>> getMovieList() {
        return Single.create(new SingleOnSubscribe<Response<MovieListResponse>>() {
            @Override
            public void subscribe(SingleEmitter<Response<MovieListResponse>> e) throws Exception {
                MovieListResponse movieListResponse = new MovieListResponse();
                movieListResponse.id = 1;
                Response<MovieListResponse> response = Response.success(movieListResponse);
                e.onSuccess(response);
            }
        });
    }
}
