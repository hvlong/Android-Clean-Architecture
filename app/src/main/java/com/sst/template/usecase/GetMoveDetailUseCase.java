package com.sst.template.usecase;

import com.sst.template.data.DataRepository;
import com.sst.template.models.Movie;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Response;

/**
 * @author LongHV.
 */
public class GetMoveDetailUseCase extends UseCase<Movie, GetMoveDetailUseCase.Params> {

    private DataRepository mDataRepository;

    @Inject
    GetMoveDetailUseCase(DataRepository dataRepository) {
        this.mDataRepository = dataRepository;
    }

    @Override
    Single<Response<Movie>> buildUseCaseObservable(Params params) {
        return mDataRepository.requestMovieDetail(params.id);
    }

    public static final class Params {

        private final int id;

        private Params(int id) {
            this.id = id;
        }

        public static GetMoveDetailUseCase.Params forMovie(int id) {
            return new GetMoveDetailUseCase.Params(id);
        }
    }
}
