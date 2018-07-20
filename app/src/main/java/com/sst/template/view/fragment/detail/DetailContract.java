package com.sst.template.view.fragment.detail;

import com.sst.template.models.Movie;
import com.sst.template.view.base.BaseView;

/**
 * @author LongHV.
 */

public class DetailContract {

    interface View extends BaseView {
        void initializeMovieDetail(Movie movie);
    }

    interface Presenter {
        void getMovieDetail(int id);
    }
}
