package com.sst.template.data.remote.network;

import com.google.gson.annotations.SerializedName;

public class BodyErrorResponse {

    @SerializedName("status_code")
    public String statusCode;

    @SerializedName("status_message")
    public String message;
}
