package com.zisal.jelling.service.listener;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import id.co.telkomsigma.mqa_background.R;

/**
 * Created on 6/22/2015 : 3:02 PM.
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class MQANotification {

    private Context context;
    private NotificationManager notificationManager;

    public MQANotification(Context context) {
        this.context = context;
        notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
    }

    public void showSingleInformation(String p_Information){
        NotificationCompat.Builder notification = new NotificationCompat.Builder(context);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, new Intent(), PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pi);
        notification.setContentTitle(context.getResources().getString(R.string.action_bar_title));
        notification.setContentText(p_Information);
        notification.setSmallIcon(R.drawable.ic_launcher);

        /*service.startForeground(R.string.parent_app_name, notification.build());*/

        notificationManager.notify(R.string.parent_app_name, notification.build());
    }

    public void showMultipleInformation(String p_Information, int p_NotificationNumber){
        NotificationCompat.Builder notification = new NotificationCompat.Builder(context);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, new Intent(), PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pi);
        notification.setContentTitle(context.getResources().getString(R.string.action_bar_title));
        notification.setContentText(p_Information);
        notification.setSmallIcon(R.drawable.ic_launcher);

        /*notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notification.defaults |= Notification.DEFAULT_SOUND;
        notification.defaults |= Notification.DEFAULT_VIBRATE;*/
        /*service.startForeground(R.string.parent_app_name, notification.build());*/

        notificationManager.notify(p_NotificationNumber, notification.build());
    }
}
