package com.sst.template.usecase;

import com.sst.template.data.DataRepository;
import com.sst.template.models.MovieListResponse;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Response;

/**
 * @author LongHV.
 */

public class GetMovieListUseCase extends UseCase<MovieListResponse, GetMovieListUseCase.Params> {

    private DataRepository mDataRepository;

    @Inject
    GetMovieListUseCase(DataRepository dataRepository) {
        super();
        this.mDataRepository = dataRepository;
    }

    @Override
    Single<Response<MovieListResponse>> buildUseCaseObservable(Params params) {
        return mDataRepository.requestMovieList(params.year);
    }

    public static final class Params {

        private final int year;

        private Params(int year) {
            this.year = year;
        }

        public static Params forYearMovie(int year) {
            return new Params(year);
        }
    }
}
