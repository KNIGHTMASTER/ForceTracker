package com.tripoin.tripoin_rest.endpoints;


import com.tripoin.tripoin_rest.callback.CallBackUserTracking;
import com.tripoin.tripoin_rest.dto.request.DTOUserTracking;

import retrofit.http.Body;
import retrofit.http.POST;

/**
 * Created on 6/5/2015 : 2:13 PM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface EPUserTracking {

    @POST("/update/location")
    void trackUser(@Body DTOUserTracking dtoUserTracking, CallBackUserTracking callBackUserTracking);
}
