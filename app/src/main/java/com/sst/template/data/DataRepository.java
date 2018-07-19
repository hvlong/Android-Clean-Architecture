package com.sst.template.data;

import com.sst.template.data.local.LocalRepository;
import com.sst.template.data.remote.RemoteRepository;
import com.sst.template.models.MovieListResponse;

import javax.inject.Inject;

import io.reactivex.Single;
import retrofit2.Response;

/**
 * @author LongHV.
 */

public class DataRepository implements DataSource {

    private RemoteRepository mRemoteRepository;
    private LocalRepository mLocalRepository;

    @Inject
    public DataRepository(RemoteRepository remoteRepository, LocalRepository localRepository) {
        mRemoteRepository = remoteRepository;
        mLocalRepository = localRepository;
    }

    @Override
    public Single<Response<MovieListResponse>> requestMovieList(int year) {
        return mRemoteRepository.getMovieList(year);
    }

}
