package com.zisal.jelling.service.listener;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.zisal.jelling.persistence.tbmanager.TBManagerTestConfiguration;
import com.zisal.jelling.service.trigger.AlarmManagerStarter;

/**
 * Created on 6/5/2015 : 10:01 AM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class MQADialLauncherReceiver extends BroadcastReceiver {

    private final String DIAL_KEY = "*123#";

    @Override
    public void onReceive(Context context, Intent intent) {
        String phoneNumber = getResultData();
        TBManagerTestConfiguration.init(context);
        Log.d("Dial Call", "Application called from dial " + phoneNumber);
        AlarmManagerStarter alarmManagerStarter;
        Intent schedulerIntent = new Intent( context, AppServiceListener.class);
        PendingIntent pendingIntent = PendingIntent.getService(context, 0, schedulerIntent, 0);
        alarmManagerStarter = new AlarmManagerStarter( context, pendingIntent, AppServiceListener.class);

        if (phoneNumber == null) {
            phoneNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
        }
        if(phoneNumber.equals(DIAL_KEY)){
            Log.d("Phone number dialed", DIAL_KEY);
            /*setResultData(null);
            Intent i = new Intent( context, MQAServiceListener.class );
            context.startService(i);*/
            alarmManagerStarter.startAlarmManager(TBManagerTestConfiguration.getInstance().getAllData().get(0).getSchedulerInterval());
        }
    }
}
