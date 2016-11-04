package com.zisal.jelling.rest.dto.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created on 8/21/2015 : 3:15 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DTOGetConfigs {

    @SerializedName("user_code")
    private String user_code;

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    @Override
    public String toString() {
        return "DTOGetConfigs{" +
                "user_code='" + user_code + '\'' +
                '}';
    }
}
