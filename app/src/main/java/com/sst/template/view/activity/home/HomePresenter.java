package com.sst.template.view.activity.home;

import com.sst.template.data.remote.network.NetworkError;
import com.sst.template.models.MovieListResponse;
import com.sst.template.usecase.GetMovieListUseCase;
import com.sst.template.view.base.BasePresenter;
import com.sst.template.usecase.BaseObserver;

import javax.inject.Inject;

/**
 * @author LongHV.
 */

public class HomePresenter extends BasePresenter<HomeView> implements HomeContract {

    private GetMovieListUseCase mGetMovieListUseCase;

    @Inject
    HomePresenter(GetMovieListUseCase getMovieListUseCase) {
        this.mGetMovieListUseCase = getMovieListUseCase;
    }

    @Override
    public void unSubscribe() {
        this.mGetMovieListUseCase.dispose();
    }

    @Override
    public void getMovieListData() {
        getView().showLoading();
        this.mGetMovieListUseCase.execute(new BaseObserver<MovieListResponse>() {
            @Override
            public void onSuccessfulResponse(MovieListResponse response) {
                getView().hideLoading();
                getView().initializeMovieList(response);
            }

            @Override
            public void onFailure(NetworkError networkError) {
                getView().hideLoading();
                handleApiError(networkError);

            }
        }, GetMovieListUseCase.Params.forYearMovie(2000));
    }
}
