package com.zisal.jelling.bgtesting.postprocess;


import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.zisal.jelling.ApplicationConstant;
import com.zisal.jelling.persistence.model.impl.ModelUserTracking;
import com.zisal.jelling.persistence.tbmanager.TBManagerUserTracking;
import com.zisal.jelling.rest.backgroundprocess.bgp.BGPUserTracking;
import com.zisal.jelling.rest.backgroundprocess.post.IPostUserTracking;
import com.zisal.jelling.rest.dto.request.impl.usertracking.DTOUserTracking;
import com.zisal.jelling.util.TestPropertyGenerator;

import id.co.telkomsigma.arium.mforce.mqa.component.phonenetwork.dto.DTOPhoneNetwork;
import retrofit.RetrofitError;

/**
 * Created on 6/5/2015 : 11:37 AM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class UserTracking implements IPostUserTracking{

    private DTOUserTracking dtoUserTracking;
    private Context context;

    public UserTracking(Context context) {
        this.context = context;
    }

    public void callUserTracking(DTOPhoneNetwork dtoPhoneNetwork){
        dtoUserTracking = new TestPropertyGenerator().generateDTOUserTracking(dtoPhoneNetwork);
        process();
    }

    public void process() {
        new BGPUserTracking() {
            @Override
            public DTOUserTracking dtoUserTracking() {
                return dtoUserTracking;
            }

            @Override
            public IPostUserTracking postUserTracking() {
                return UserTracking.this;
            }
        }.execute();
    }


    @Override
    public void onPostSuccessUserTracking(Integer data) {
        Log.i("SUCCESS", "SUCCESS UPDATE LOCATION");
    }

    @Override
    public void onPostFailureUserTracking(RetrofitError error) {
        Log.d("Error user Tracking", error.getMessage());
        //saveUserTracking(dtoUserTracking);
    }

    private void saveUserTracking(DTOUserTracking dtoUserTracking){
        try{
            Log.i(ApplicationConstant.LogTag.MQA_INFO, "Saving failed User Tracking");
            TBManagerUserTracking.init(context);
            ModelUserTracking modelUserTracking = new ModelUserTracking();
            modelUserTracking.setUserTrackingJsonData(new Gson().toJson(dtoUserTracking));
            TBManagerUserTracking.getInstance().insertEntity(modelUserTracking);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
