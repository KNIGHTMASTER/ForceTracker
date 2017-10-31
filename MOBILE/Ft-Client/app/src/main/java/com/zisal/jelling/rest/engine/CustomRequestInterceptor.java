package com.zisal.jelling.rest.engine;

import com.zisal.jelling.ApplicationConstant;
import id.co.telkomsigma.mforce.mqa.common.component.GeneralConstant;
import id.co.telkomsigma.mforce.mqa.common.component.GeneralConverter;
import retrofit.RequestInterceptor;

/**
 * Created on 5/26/2015 : 10:39 AM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class CustomRequestInterceptor implements RequestInterceptor {

    private String credentials;

    public CustomRequestInterceptor(String credentials) {
        this.credentials = credentials;
    }

    @Override
    public void intercept(RequestFacade request) {
        request.addHeader(
                ApplicationConstant.Rest.AUTHORIZATION,
                ApplicationConstant.Rest.BASIC.
                        concat(GeneralConstant.Punctuation.SPACE).
                        concat(new GeneralConverter().encodeToBase64(credentials))
        );
        request.addHeader(
                ApplicationConstant.Rest.ACCEPT,
                ApplicationConstant.Rest.APPLICATION_JSON
        );
    }

}
