package com.zisal.jelling.service.listener;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;


import com.zisal.jelling.persistence.tbmanager.TBManagerTestConfiguration;
import com.zisal.jelling.service.trigger.AlarmManagerStarter;
import id.co.telkomsigma.mforce.mqa.common.component.GeneralConstant;

/**
 * Created on 5/9/2015 : 10:50 AM.
 * mailto : @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class MQABroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("BROADCAST RECEIVER", intent.getAction());
        TBManagerTestConfiguration.init(context);
        AlarmManagerStarter alarmManagerStarter;
        Intent schedulerIntent = new Intent( context, AppServiceListener.class);
        PendingIntent pendingIntent = PendingIntent.getService(context, 0, schedulerIntent, 0);
        alarmManagerStarter = new AlarmManagerStarter( context, pendingIntent, AppServiceListener.class);

        if ( intent.getAction().equals(GeneralConstant.BroadcastMessage.RESTART_SERVICE) ){
            alarmManagerStarter.startAlarmManager(TBManagerTestConfiguration.getInstance().getAllData().get(0).getSchedulerInterval());
        }else{
            Intent i = new Intent( context, AppServiceListener.class );
            context.startService( i );
        }
    }
}
