package com.tripoin.tripoin_rest.bgp.impl;

import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.tripoin.tripoin_common.constant.ApplicationConstant;
import com.tripoin.tripoin_rest.callback.CallBackUserTracking;
import com.tripoin.tripoin_rest.dto.request.DTOUserTracking;
import com.tripoin.tripoin_rest.endpoints.EPUserTracking;
import com.tripoin.tripoin_rest.engine.RestGenerator;
import com.tripoin.tripoin_rest.engine.RestParameter;
import com.tripoin.tripoin_rest.post.IPostUserTracking;


/**
 * Created on 6/1/2015 : 2:12 PM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public abstract class BGPUserTracking extends AsyncTask {

    protected Dialog dialog;

    @Override
    protected Object doInBackground(Object[] params) {
        RestGenerator restGenerator = new RestGenerator();
        RestParameter restParameter = new RestParameter();
        restParameter.setChipperAuth("");
        restParameter.setContext(getContext());
        restGenerator.setParameter(restParameter);
        EPUserTracking epUserTracking = (EPUserTracking) restGenerator.createService(EPUserTracking.class);
        epUserTracking.trackUser(dtoUserTracking(), new CallBackUserTracking(postUserTracking()));
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if(dialog != null){
            dialog.show();
        }else if(dialog == null){
            if(getProgressDialog() != null){
                dialog = getProgressDialog();
                dialog.dismiss();
                dialog.show();
            }
        }
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        Log.i(ApplicationConstant.Log.TRIPOIN_INFO, "Post Execute BGP");
        if (dialog != null){
            dialog.dismiss();
        }
    }

    public abstract Context getContext();

    public abstract DTOUserTracking dtoUserTracking();

    public abstract IPostUserTracking postUserTracking();

    public abstract Dialog getProgressDialog();
}
