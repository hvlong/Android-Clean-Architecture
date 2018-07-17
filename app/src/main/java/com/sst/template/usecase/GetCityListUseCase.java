package com.sst.template.usecase;

import com.sst.template.data.DataRepository;
import com.sst.template.models.CityListResponse;
import com.sst.template.service.BaseCallback;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

/**
 * @author LongHV.
 */

public class GetCityListUseCase implements UseCase {

    private DataRepository mDataRepository;
    private CompositeDisposable mCompositeDisposable;

    private Disposable mDisposable;
    private Single<Response<CityListResponse>> mCityListSingle;

    @Inject
    public GetCityListUseCase(DataRepository dataRepository, CompositeDisposable compositeDisposable) {
        this.mDataRepository = dataRepository;
        this.mCompositeDisposable = compositeDisposable;
    }

    @Override
    public void getNews(BaseCallback<CityListResponse> callback) {
        if (!mCompositeDisposable.isDisposed()) {
            mCityListSingle = mDataRepository.requestCityList();
            mDisposable = mCityListSingle
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(callback);
            mCompositeDisposable.add(mDisposable);
        }
    }
}
