package com.zisal.jelling.rest.dto.request.impl;

import com.google.gson.annotations.SerializedName;

import com.zisal.jelling.rest.dto.request.DTOBaseRequest;

/**
 * Created on 6/1/2015 : 11:51 AM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DTORequestAutomaticActivation extends DTOBaseRequest {

    @SerializedName("deviceid")
    private String deviceid;

    @SerializedName("user_code")
    private String user_code;

    @SerializedName("datetime")
    private String datetime;

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "DTORequestAutomaticActivation{" +
                "deviceid='" + deviceid + '\'' +
                ", user_code='" + user_code + '\'' +
                ", datetime='" + datetime + '\'' +
                '}';
    }
}
