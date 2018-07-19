package com.sst.template.view.activity.home;

import com.sst.template.models.MovieListResponse;
import com.sst.template.view.base.BaseView;

/**
 * @author LongHV.
 */
public interface HomeView extends BaseView {

    void initializeMovieList(MovieListResponse movieListResponse);

}
