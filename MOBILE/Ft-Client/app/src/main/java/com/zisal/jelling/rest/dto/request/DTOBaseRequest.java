package com.zisal.jelling.rest.dto.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created on 6/1/2015 : 11:50 AM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DTOBaseRequest {

    @SerializedName("rqid")
    private String rqid;

    public String getRqid() {
        return rqid;
    }

    public void setRqid(String rqid) {
        this.rqid = rqid;
    }

    @Override
    public String toString() {
        return "DTOBaseRequest{" +
                "rqid='" + rqid + '\'' +
                '}';
    }
}
