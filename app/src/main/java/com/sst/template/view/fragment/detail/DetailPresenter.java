package com.sst.template.view.fragment.detail;

import com.sst.template.data.remote.network.NetworkError;
import com.sst.template.models.Movie;
import com.sst.template.usecase.BaseObserver;
import com.sst.template.usecase.GetMoveDetailUseCase;
import com.sst.template.view.base.BasePresenter;

import javax.inject.Inject;

/**
 * @author LongHV.
 */

public class DetailPresenter extends BasePresenter<DetailContract.View> implements DetailContract.Presenter {

    private GetMoveDetailUseCase mGetMoveDetailUseCase;

    @Inject
    DetailPresenter(GetMoveDetailUseCase getMoveDetailUseCase) {
        this.mGetMoveDetailUseCase = getMoveDetailUseCase;
    }

    @Override
    public void unSubscribe() {
        this.mGetMoveDetailUseCase.dispose();
    }

    @Override
    public void getMovieDetail(int id) {
        getView().showLoading();
        mGetMoveDetailUseCase.execute(new BaseObserver<Movie>() {
            @Override
            public void onSuccessfulResponse(Movie response) {
                getView().hideLoading();
                getView().initializeMovieDetail(response);
            }

            @Override
            public void onFailure(NetworkError networkError) {
                getView().hideLoading();
                handleApiError(networkError);
            }
        }, GetMoveDetailUseCase.Params.forMovie(id));
    }
}
