package com.zisal.jelling.util;

import android.content.Context;
import android.util.Log;

import com.zisal.jelling.ApplicationConstant;
import com.zisal.jelling.persistence.model.ModelDynamicTestConfiguration;
import com.zisal.jelling.persistence.tbmanager.TBManagerTestConfiguration;

/**
 * Created on 3/3/2016 : 3:17 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class PhoneNumberRecognition {

    private Context context;

    public PhoneNumberRecognition(Context p_Context) {
        this.context = p_Context;
        TBManagerTestConfiguration.init(p_Context);
    }

    public String getStoredPhoneNumber(){
        ModelDynamicTestConfiguration modelDynamicTestConfiguration;
        try{
            modelDynamicTestConfiguration = TBManagerTestConfiguration.getInstance().getAllData().get(0);
            Log.d(ApplicationConstant.LogTag.MQA_INFO, "Stored Phone Number : ".concat(modelDynamicTestConfiguration.getPhoneNumber()));
            return modelDynamicTestConfiguration.getPhoneNumber();
        }catch (Exception e){
            Log.d(ApplicationConstant.LogTag.MQA_ERROR, "can not select ModelDynamicTestConfiguration : ".concat(e.getMessage()));
            return "";
        }
    }
}
