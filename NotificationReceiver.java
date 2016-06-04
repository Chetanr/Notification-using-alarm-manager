package com.example.avinash.zapp;

/**
 * Created by Chetan on 31-05-2016.
 */
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.TextView;

public class NotificationReceiver extends BroadcastReceiver
{
    @Override
    public void onReceive(Context context, Intent intent)
    {

        Intent service1 = new Intent(context, startservice.class);
	     context.startService(service1);
        Log.i("App", "called receiver method");
        try
        {
            Utils.generateNotification(context);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        TextView tv = (TextView) findViewById(R.id.hi);
//        tv.setText("Yo!");
//
//        setContentView(tv);
//    }
}