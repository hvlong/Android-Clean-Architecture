package com.sst.template.view.activity.home;

import com.sst.template.base.BaseView;
import com.sst.template.models.CityListResponse;

/**
 * @author LongHV.
 */

public interface HomeView extends BaseView {
    
    void initializeCityList(CityListResponse cityListResponseList);

}
