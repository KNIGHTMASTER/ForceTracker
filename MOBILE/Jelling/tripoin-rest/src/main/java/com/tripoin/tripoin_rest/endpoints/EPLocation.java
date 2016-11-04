package com.tripoin.tripoin_rest.endpoints;

import com.tripoin.tripoin_common.constant.ApplicationConstant;
import com.tripoin.tripoin_rest.dto.request.location.DTORequestLocation;
import com.tripoin.tripoin_rest.dto.response.location.DTOResponseLocation;
import com.tripoin.tripoin_rest.dto.response.login.DTOResponseLogin;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created on 6/1/2015 : 11:44 AM.
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface EPLocation {

    @GET(ApplicationConstant.Rest.EndPoints.LOCATION)
    void getLocation(
            Callback<List<DTOResponseLocation>> dtoResponseLocation
    );
}
