package com.example.avinash.zapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class notification extends AppCompatActivity
{
    //String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.notify);
       // uid=getIntent().getExtras().getString("uid");

//        getnotif b = new getnotif(this);
//        b.execute();
        //Locale locale=Locale.
        AlarmManager manager= (AlarmManager) getSystemService(ALARM_SERVICE);
        TimeZone zone=TimeZone.getTimeZone("IST");
        Calendar cal=Calendar.getInstance(zone);
        System.out.println(cal);
        cal.setTimeInMillis(System.currentTimeMillis());
        //cal.set(Calendar.AM_PM,Calendar.PM);
        cal.set(Calendar.HOUR_OF_DAY,11);
        cal.set(Calendar.MINUTE,55);
        cal.set(Calendar.SECOND,0);


        Intent intent = new Intent(this, NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

       manager.setRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),manager.INTERVAL_DAY,pendingIntent);



    }

  /*  public void display(View view)
    {
        /*final NotificationCompat.Builder builder= new  NotificationCompat.Builder(this);
        final int notify_id=1;*/

       /* Intent intent = new Intent(this, NotificationReceiver.class);
        //PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        final PendingIntent pendingIntent=PendingIntent.getService(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        final AlarmManager manager= (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Calendar cal=Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        cal.set(Calendar.HOUR_OF_DAY,14);
        cal.set(Calendar.MINUTE,30);
        cal.set(Calendar.SECOND,0);*/

        //manager.setRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
//        final NotificationManager notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        builder.setSmallIcon(R.drawable.common_full_open_on_phone);
//        builder.setContentTitle("Notification");
//        builder.setContentText("Progress");
//        builder.addAction(R.drawable.common_full_open_on_phone,"View",pendingIntent);
//        builder.setContentIntent(pendingIntent);
//        notificationManager.notify(notify_id,builder.build());
//        Thread timer=new Thread(new Runnable()
//        {
//            @Override
//            public void run()
//            {
//
//                notif();
//            }
//        });
//        timer.start();

               /* Calendar cal=Calendar.getInstance();
                cal.setTimeInMillis(System.currentTimeMillis());
                cal.set(Calendar.HOUR,17);
                cal.set(Calendar.MINUTE,31);
                cal.set(Calendar.SECOND,0);

                manager.setRepeating(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);*/
//                for(int i=0;i<100;i+=5)
//                {
//                    builder.setProgress(100,i,false);
//                    notificationManager.notify(notify_id,builder.build());
//                }
//                builder.setProgress(0,0,false);
//                builder.setContentText("Done!");
//                notificationManager.notify(notify_id,builder.build());



   // }


//    public void notif()
//    {
//
//        Calendar cal=Calendar.getInstance();
//        cal.setTimeInMillis(System.currentTimeMillis());
//        cal.set(Calendar.AM_PM,Calendar.PM);
//        cal.set(Calendar.HOUR,12);
//        cal.set(Calendar.MINUTE,58);
//        cal.set(Calendar.SECOND,0);
//
//        Intent intent = new Intent(this, NotificationReceiver.class);
//        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
//        AlarmManager manager= (AlarmManager) getSystemService(ALARM_SERVICE);
//        manager.setRepeating(AlarmManager.RTC,cal.getTimeInMillis(),86400000,pendingIntent);
//    }







//   public class getnotif extends AsyncTask<Void, Void, String>
//    {
//
//        Context ctx;
//        int count;
//        String tip,a,b,c,d,quest,answer;
//        public getnotif(Context ctx)
//        {
//            this.ctx=ctx;
//        }
//
//
//        String j_url,j_string;
//
//
//
//        @Override
//        protected void onPreExecute()
//        {
//            j_url="http://niyut.esy.es/tip.php";
//        }
//
//
//
//        @Override
//        protected String doInBackground(Void... params)
//        {
//            try
//            {
//                URL url=new URL(j_url);
//                HttpURLConnection ht= (HttpURLConnection) url.openConnection();
//                ht.setRequestMethod("POST");
//                ht.setDoOutput(true);
//                OutputStream os=ht.getOutputStream();
//                BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
//                String data = URLEncoder.encode("tno", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8");
//                bf.write(data);
//                bf.flush();
//                os.close();
//                InputStream is = ht.getInputStream();
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
//                StringBuilder sb = new StringBuilder();
//                while ((j_string = bufferedReader.readLine()) != null) {
//                    sb.append(j_string + "\n");
//                }
//                bufferedReader.close();
//                is.close();
//                ht.disconnect();
//
//            }
//            catch (MalformedURLException e)
//            {
//                e.printStackTrace();
//            }
//            catch (IOException e)
//            {
//                e.printStackTrace();
//            }
//
//            String ans="sorry";
//
//            return ans;
//        }
//
//        @Override
//        protected  void  onPostExecute(String result)
//        {
//            TextView tv = (TextView) findViewById(R.id.hi);
//
//
//
//
//            j_string=result;
//
//
//            try {
//                int count1=0;
//
//                JSONObject jo = new JSONObject(j_string);
//                JSONArray ja = jo.getJSONArray("product");
//
//
//
//                JSONObject jo1 = ja.getJSONObject(count1);
//
//                tip=jo1.getString("tip");
////                quest = jo1.getString("quest");
////                a = jo1.getString("a");
////                b = jo1.getString("b");
////                c = jo1.getString("c");
////                d = jo1.getString("d");
////                answer = jo1.getString("ans");
//
//
//
//
//
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//            try {
//                JSONObject jo=new JSONObject(j_string);
//
//                count=jo.getInt("tno");
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//            tv.setText(tip);
//            RadioButton r1 = (RadioButton) findViewById(R.id.a);
//            r1.setText(a);
//            RadioButton r2 = (RadioButton) findViewById(R.id.b);
//            r2.setText(b);
//            RadioButton r3 = (RadioButton) findViewById(R.id.c);
//            r3.setText(c);
//            RadioButton r4 = (RadioButton) findViewById(R.id.d);
//            r4.setText(d);
//
//        }
//
//    }


}

