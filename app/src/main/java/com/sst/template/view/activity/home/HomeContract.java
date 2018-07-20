package com.sst.template.view.activity.home;

import com.sst.template.models.MovieListResponse;
import com.sst.template.view.base.BaseView;

/**
 * @author LongHV.
 */
public interface HomeContract {

    interface View extends BaseView {
        void initializeMovieList(MovieListResponse movieListResponse);
    }

    interface Presenter {
        void getMovieListData();
    }
}
