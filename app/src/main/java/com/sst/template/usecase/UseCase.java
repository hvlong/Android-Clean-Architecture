package com.sst.template.usecase;


import com.sst.template.models.CityListResponse;
import com.sst.template.service.BaseCallback;

public interface UseCase {

    void getNews(BaseCallback<CityListResponse> observable);

}
