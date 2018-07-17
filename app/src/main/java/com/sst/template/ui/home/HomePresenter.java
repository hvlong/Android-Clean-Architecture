package com.sst.template.ui.home;

import android.util.Log;

import com.sst.template.models.CityListResponse;
import com.sst.template.service.BaseCallback;
import com.sst.template.service.NetworkError;
import com.sst.template.usecase.GetCityListUseCase;

import javax.inject.Inject;

/**
 * @author LongHV.
 */

public class HomePresenter {

    private GetCityListUseCase getCityListUseCase;

    @Inject
    public HomePresenter(GetCityListUseCase getCityListUseCase) {
        this.getCityListUseCase = getCityListUseCase;
    }

    void getCityListData() {
        this.getCityListUseCase.getNews(new BaseCallback<CityListResponse>() {

            @Override
            public void onSuccessfulResponse(CityListResponse response) {
                Log.d("longhv", "response" + response.getMessage());
            }

            @Override
            public void onFailure(NetworkError error) {
                Log.d("longhv", "onFailure" + error.getMessage());
            }
        });
    }

}
