package com.zisal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.zisal.jelling.ApplicationConstant.LogTag;
import com.zisal.jelling.persistence.tbmanager.TBManagerTestConfiguration;
import com.zisal.jelling.service.listener.AppServiceListener;
import com.zisal.jelling.service.trigger.AlarmManagerStarter;
import id.co.telkomsigma.mqa_background.R;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TBManagerTestConfiguration.init(this);

        startMainService(this);

    }

    private void startMainService(Context p_Context){
        Intent schedulerIntent = new Intent(p_Context, AppServiceListener.class);
        PendingIntent pendingIntent = PendingIntent.getService(p_Context, 0, schedulerIntent, 0);
        AlarmManagerStarter alarmManagerStarter = new AlarmManagerStarter( this, pendingIntent, AppServiceListener.class );
        try{
            alarmManagerStarter.startAlarmManager(TBManagerTestConfiguration.getInstance().getAllData().get(0).getSchedulerInterval());
        }catch (Exception e){
            Log.e(LogTag.MQA_ERROR, "Can not run main service : ".concat(e.getMessage()));
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        onLowMemory();
    }
}
