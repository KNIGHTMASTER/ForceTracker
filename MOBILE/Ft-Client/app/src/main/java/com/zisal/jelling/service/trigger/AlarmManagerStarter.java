package com.zisal.jelling.service.trigger;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Calendar;

import com.zisal.jelling.ApplicationConstant;


/**
 * Created on 11/23/2014.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 *
 * Daemon Class to start/ restart the Scheduler
 */
public class AlarmManagerStarter<SERVICE_CLASS> {

    private Context context;
    private PendingIntent pendingIntent;
    private Intent myIntent;
    private AlarmManager alarmManager;
    private Class<SERVICE_CLASS> serviceClass;

    public AlarmManagerStarter(Context p_Context,  PendingIntent p_PendingIntent, Class<SERVICE_CLASS> p_ServiceClass) {
        if ( p_Context != null ){
            this.context = p_Context;
        }
        this.pendingIntent = p_PendingIntent;
        this.serviceClass = p_ServiceClass;
    }

    public void startAlarmManager(int p_Interval){
        Log.i(ApplicationConstant.LogTag.MQA_INFO, "Alarm Manager Started");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, 1);
        int interval = 40;
        try{
            interval = p_Interval;
            Log.i(ApplicationConstant.LogTag.MQA_INFO, "Scheduler ".concat(serviceClass.getSimpleName()).concat(" set to ".concat(String.valueOf(interval)).concat(" seconds per cycle")));
        }catch (Exception e){
            Log.e("WAKE TIME", "using default 120 seconds per cycle");
        }

        if (context != null){
            myIntent = new Intent( context, serviceClass);
            pendingIntent = PendingIntent.getService(context, 0, myIntent, 0);
            if (alarmManager == null){
                alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), interval * 1000, pendingIntent);
            }else{
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), interval * 1000, pendingIntent);
            }
        }else{
            myIntent = new Intent(context, serviceClass);
            pendingIntent = PendingIntent.getService( context, 0, myIntent, 0);
            alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        }
    }


    public void stopSchedulerService(){
        myIntent = new Intent(context, serviceClass);
        context.stopService( myIntent );
    }

}
