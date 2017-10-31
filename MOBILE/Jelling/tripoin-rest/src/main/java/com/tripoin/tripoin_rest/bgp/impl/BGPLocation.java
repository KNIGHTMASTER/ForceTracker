package com.tripoin.tripoin_rest.bgp.impl;

import com.tripoin.tripoin_rest.bgp.base.ABGP;
import com.tripoin.tripoin_rest.callback.GenericCallBack;
import com.tripoin.tripoin_rest.endpoints.EPLocation;
import com.tripoin.tripoin_rest.post.IGenericPost;

import retrofit.Callback;

/**
 * Created on 10/1/2015 : 4:56 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class BGPLocation extends ABGP{

    public BGPLocation(IGenericPost iGenericPost) {
        super(iGenericPost);
    }

    @Override
    protected Object doInBackground(Object[] params) {
        EPLocation epLocation = (EPLocation) restGenerator.createService(getEPClass());
        epLocation.getLocation(getCallBack());
        return null;
    }

    @Override
    public Callback getCallBack() {
        return new GenericCallBack(iGenericPost);
    }

    @Override
    public Class getEPClass() {
        return EPLocation.class;
    }
}
