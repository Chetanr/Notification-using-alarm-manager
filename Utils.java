package com.example.avinash.zapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

/**
 * Created by Chetan on 01-06-2016.
 */
public class Utils
{
    //public static NotificationManager mManager;

    @SuppressWarnings("static-access")
    public static void generateNotification(Context context){

       // NotificationManager manager= (NotificationManager) context.getApplicationContext().getSystemService(context.NOTIFICATION_SERVICE);
        Intent intent1=new Intent(context.getApplicationContext(),notification.class);

        PendingIntent pendingIntent = PendingIntent.getActivity( context.getApplicationContext(),0, intent1,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = (NotificationCompat.Builder) new NotificationCompat.Builder(context).setSmallIcon(R.drawable.common_full_open_on_phone).setContentTitle("Notification").setContentText("Hi");
        builder.setContentIntent(pendingIntent);
        builder.setDefaults(Notification.DEFAULT_SOUND);
        NotificationManager notificationManager;
        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, builder.build());
    }
}
