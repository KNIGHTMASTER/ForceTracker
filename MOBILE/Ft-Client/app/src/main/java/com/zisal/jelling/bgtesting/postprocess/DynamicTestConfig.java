package com.zisal.jelling.bgtesting.postprocess;

import android.content.Context;
import android.util.Log;

import com.zisal.jelling.ApplicationConstant;
import com.zisal.jelling.persistence.model.ModelDynamicTestConfiguration;
import com.zisal.jelling.persistence.tbmanager.TBManagerTestConfiguration;

import id.co.telkomsigma.arium.mforce.mqa.component.phonenetwork.phonenetwork.PhoneNetwork;
import id.co.telkomsigma.arium.mforce.mqa.component.phonenetwork.phonenetwork.PhoneNetworkParam;

/**
 * Created on 8/19/2015 : 1:36 PM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DynamicTestConfig {

    private Context context;
    private String command;

    public void callDynamicTestConfig(Context context, String command){
        this.context = context;
        this.command = command;
        PhoneNetworkParam phoneNetworkParam = new PhoneNetworkParam();
        phoneNetworkParam.setContext(this.context);
        PhoneNetwork phoneNetwork = new PhoneNetwork();
        phoneNetwork.setParameter(phoneNetworkParam);
    }



    public void generateDummyConfiguration(Context context){
        TBManagerTestConfiguration.init(context);
        ModelDynamicTestConfiguration modelDynamicTestConfiguration = null;
        try{
            modelDynamicTestConfiguration = TBManagerTestConfiguration.getInstance().getAllData().get(0);
        }catch (Exception e){
            if(modelDynamicTestConfiguration == null){

                Log.d(ApplicationConstant.LogTag.MQA_INFO, "Host is set to : ".concat(ApplicationConstant.Rest.HOST_PROD));
                modelDynamicTestConfiguration = new ModelDynamicTestConfiguration();
                modelDynamicTestConfiguration.setHost(ApplicationConstant.Rest.HOST_PROD);

                modelDynamicTestConfiguration.setPort(ApplicationConstant.Rest.PORT_DEV);
                modelDynamicTestConfiguration.setSchedulerInterval(ApplicationConstant.Rest.SCHEDULER_INTERVAL);
                modelDynamicTestConfiguration.setStartWorkingHour(ApplicationConstant.Rest.START_WORKING_HOUR);
                modelDynamicTestConfiguration.setStopWorkingHour(ApplicationConstant.Rest.STOP_WORKING_HOUR);
                TBManagerTestConfiguration.getInstance().insertEntity(modelDynamicTestConfiguration);
            }
        }
    }
}
