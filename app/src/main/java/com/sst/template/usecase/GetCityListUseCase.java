package com.sst.template.usecase;

import com.sst.template.data.DataRepository;
import com.sst.template.models.CityListResponse;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Response;

/**
 * @author LongHV.
 */
public class GetCityListUseCase extends UseCase<CityListResponse, Void> {

    private DataRepository mDataRepository;

    @Inject
    GetCityListUseCase(DataRepository dataRepository) {
        super();
        this.mDataRepository = dataRepository;
    }

    @Override
    Single<Response<CityListResponse>> buildUseCaseObservable(Void aVoid) {
        return null;
    }

//    @Override
//    Single<BodyErrorResponse<CityListResponse>> buildUseCaseObservable(Void aVoid) {
//        return this.mDataRepository.requestCityList();
//    }

//    public static final class Params {
//
//        private final int userId;
//
//        private Params(int userId) {
//            this.userId = userId;
//        }
//
//        public static Params forUser(int userId) {
//            return new Params(userId);
//        }
//    }

}
