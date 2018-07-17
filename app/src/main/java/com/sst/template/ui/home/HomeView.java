package com.sst.template.ui.home;

import com.sst.template.models.CityListResponse;

public interface HomeView {
    void showWait();

    void removeWait();

    void onFailure(String appErrorMessage);

    void getCityListSuccess(CityListResponse cityListResponse);

}
