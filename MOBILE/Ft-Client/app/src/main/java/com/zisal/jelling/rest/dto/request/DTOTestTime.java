package com.zisal.jelling.rest.dto.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created on 6/22/2015 : 3:50 PM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DTOTestTime extends DTOBaseRequest{

    @SerializedName("test_id")
    private String test_id;

    @SerializedName("test_start")
    private String test_start;

    @SerializedName("test_end")
    private String test_end;

    @SerializedName("datetime")
    private String datetime;

    public String getTest_id() {
        return test_id;
    }

    public void setTest_id(String test_id) {
        this.test_id = test_id;
    }

    public String getTest_start() {
        return test_start;
    }

    public void setTest_start(String test_start) {
        this.test_start = test_start;
    }

    public String getTest_end() {
        return test_end;
    }

    public void setTest_end(String test_end) {
        this.test_end = test_end;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "DTOTestTime{" +
                "test_id='" + test_id + '\'' +
                ", test_start='" + test_start + '\'' +
                ", test_end='" + test_end + '\'' +
                ", datetime='" + datetime + '\'' +
                '}';
    }
}
