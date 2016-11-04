package com.zisal.jelling.bgtesting.postprocess;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import com.zisal.jelling.ApplicationConstant;
import com.zisal.jelling.persistence.model.impl.ModelUserTracking;
import com.zisal.jelling.persistence.tbmanager.TBManagerUserTracking;
import com.zisal.jelling.rest.backgroundprocess.bgp.BGPUserTracking;
import com.zisal.jelling.rest.backgroundprocess.post.IPostUserTracking;
import com.zisal.jelling.rest.dto.request.impl.usertracking.DTOUserTracking;
import com.zisal.jelling.rest.dto.response.DTOBaseResponse;
import retrofit.RetrofitError;

/**
 * Created on 8/28/2015 : 11:12 AM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class FailedUserTracking implements IPostUserTracking{

    private List<Integer> userTrackingId = new ArrayList<>();

    private Context context;

    public FailedUserTracking(Context context) {
        this.context = context;
    }

    public void callFailedUserTracking(){
        try{
            TBManagerUserTracking.init(context);
            List<ModelUserTracking> modelUserTrackings = TBManagerUserTracking.getInstance().getAllData();
            for(ModelUserTracking modelUserTracking: modelUserTrackings){
                userTrackingId.add(modelUserTracking.getId());
                final DTOUserTracking dtoUserTracking =
                        new Gson().fromJson(modelUserTracking.getUserTrackingJsonData(), DTOUserTracking.class);
                new BGPUserTracking() {
                    @Override
                    public DTOUserTracking dtoUserTracking() {
                        return dtoUserTracking;
                    }

                    @Override
                    public IPostUserTracking postUserTracking() {
                        return FailedUserTracking.this;
                    }
                }.execute();
            }
        }catch (Exception e){
            Log.e(ApplicationConstant.LogTag.MQA_INFO, "Failed User Tracking Is Empty");
        }
    }

    @Override
    public void onPostSuccessUserTracking(Integer data) {
        try{
            for(Integer i: userTrackingId){
                Log.i(ApplicationConstant.LogTag.MQA_INFO, "Delete failed user tracking with id ".concat(String.valueOf(i)));
                TBManagerUserTracking.getInstance().deleteEntity(i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onPostFailureUserTracking(RetrofitError error) {
        Log.i("ERROR", error.toString());
    }
}
