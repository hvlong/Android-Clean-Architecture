package com.sst.template.data.remote.network;


public class NetworkError {

    public Throwable throwable;
    public retrofit2.Response<?> response;

    public NetworkError(Throwable throwable) {
        this.throwable = throwable;
    }

    public NetworkError(retrofit2.Response<?> response) {
        this.response = response;
    }

}