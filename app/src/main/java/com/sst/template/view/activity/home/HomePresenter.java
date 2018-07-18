package com.sst.template.view.activity.home;

import com.sst.template.base.BasePresenter;
import com.sst.template.models.CityListResponse;
import com.sst.template.usecase.BaseObserver;
import com.sst.template.service.NetworkError;
import com.sst.template.usecase.GetCityListUseCase;

import javax.inject.Inject;

/**
 * @author LongHV.
 */

public class HomePresenter extends BasePresenter<HomeView> {

    private GetCityListUseCase getCityListUseCase;

    @Inject
    HomePresenter(GetCityListUseCase getCityListUseCase) {
        this.getCityListUseCase = getCityListUseCase;
    }

    @Override
    public void unSubscribe() {
        this.getCityListUseCase.dispose();
    }

    void getCityListData() {
        getView().onShowLoading();
        this.getCityListUseCase.execute(new BaseObserver<CityListResponse>() {
            @Override
            public void onSuccessfulResponse(CityListResponse response) {
                getView().onHideLoading();
                getView().initializeCityList(response);
            }

            @Override
            public void onFailure(NetworkError error) {
                getView().onHideLoading();
            }
        }, null);
    }

}
