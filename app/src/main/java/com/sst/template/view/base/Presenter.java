package com.sst.template.view.base;

import com.sst.template.data.remote.network.NetworkError;

/**
 * @author LongHV.
 */

public interface Presenter {
    void handleApiError(NetworkError networkError);
}
