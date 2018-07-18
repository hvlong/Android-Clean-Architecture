package com.sst.template.data;

import com.sst.template.data.local.LocalRepository;
import com.sst.template.data.remote.RemoteRepository;
import com.sst.template.models.CityListResponse;

import javax.inject.Inject;

import io.reactivex.Single;

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
    public Single<retrofit2.Response<CityListResponse>> requestCityList() {
//        return mLocalRepository.getNews();
        return mRemoteRepository.getNews();
    }
}
