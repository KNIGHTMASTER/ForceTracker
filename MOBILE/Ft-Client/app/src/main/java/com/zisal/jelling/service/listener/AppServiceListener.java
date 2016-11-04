package com.zisal.jelling.service.listener;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

import id.co.telkomsigma.arium.mforce.mqa.component.phonenetwork.dto.DTOPhoneNetwork;
import id.co.telkomsigma.arium.mforce.mqa.component.phonenetwork.listener.MQAPhoneStateListener;
import com.zisal.jelling.ApplicationConstant;
import com.zisal.jelling.bgtesting.postprocess.UserTracking;
import com.zisal.jelling.persistence.tbmanager.TBManagerTestConfiguration;
import com.zisal.jelling.persistence.tbmanager.TBManagerUser;
import com.zisal.jelling.util.NetworkConnectivity;
import com.zisal.jelling.util.TestPropertyGenerator;

import id.co.telkomsigma.mforce.mqa.common.component.GeneralConstant;
import id.co.telkomsigma.mforce.mqa.common.component.GeneralValidation;
import id.co.telkomsigma.mqa_background.R;

/**
 * Created on 5/30/2015 : 9:37 PM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class AppServiceListener extends Service{

    private TelephonyManager telephonyManager;
    private MQAPhoneStateListener mqaPhoneStateListener;
    private GeneralValidation generalValidation;
    private DTOPhoneNetwork dtoPhoneNetwork;


    @Override
    public void onCreate() {
        super.onCreate();
        telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        mqaPhoneStateListener = new MQAPhoneStateListener();
        generalValidation = new GeneralValidation();
        TBManagerUser.init(this);
        TBManagerTestConfiguration.init(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        telephonyManager.listen(mqaPhoneStateListener, PhoneStateListener.LISTEN_NONE);
        Intent intent = new Intent();
        intent.setAction(GeneralConstant.BroadcastMessage.RESTART_SERVICE);
        sendBroadcast(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(mqaPhoneStateListener != null){
            if(telephonyManager != null){
                telephonyManager.listen(mqaPhoneStateListener, ApplicationConstant.PhoneStateEvents.events);
            }
        }

        int startWorkingHour = TBManagerTestConfiguration.getInstance().getAllData().get(0).getStartWorkingHour();
        int stopWorkingHour = TBManagerTestConfiguration.getInstance().getAllData().get(0).getStopWorkingHour();
        NetworkConnectivity networkConnectivity = new NetworkConnectivity(this);

        /*if(generalValidation.isWorkingHour(startWorkingHour, stopWorkingHour)){*/
            if (networkConnectivity.isConnected()){
                this.dtoPhoneNetwork = new TestPropertyGenerator().provideDTOPhoneNetwork(this, mqaPhoneStateListener);
                if(dtoPhoneNetwork != null){
                    new MQANotification(this).showSingleInformation(this.getResources().getString(R.string.working_hour));
                    new UserTracking(this).callUserTracking(dtoPhoneNetwork);
                }
            }else{
                new MQANotification(this).showSingleInformation(this.getResources().getString(R.string.no_internet));
            }

        /*}else{
            new MQANotification(this).showSingleInformation(this.getResources().getString(R.string.non_working_hour));
            *//**
             * non working hour will reset test date for checking the test of application
             *//*

        }*/
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
