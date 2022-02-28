package com.example.intentservice;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class timer_service extends IntentService {
    public timer_service() {
        super("Timer Service");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.v("timer","Timer service has started.");

    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        return START_STICKY;
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        if (intent == null){
            int time=5;
            for (int i =0;i<time;i++){
                Log.v("timer","i(intent is null) ="+i);
                try{
                    Thread.sleep(1000);
                }catch (Exception e){}
            }


            return;
        }

        ResultReceiver receiver=intent.getParcelableExtra("receiver");
        int time=intent.getIntExtra("timer",0);
        for (int i =0;i<time;i++){
            Log.v("timer","i ="+i);
            try{
                Thread.sleep(1000);
            }catch (Exception e){}

        if (i==5){
            NotificationCompat.Builder nb=new NotificationCompat.Builder(this)
                .setContentTitle("Hi")
                .setContentText("Time done.")
                .setSmallIcon(R.mipmap.ic_launcher);
            NotificationManager nm=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            nm.notify(1,nb.build());
        }
        }
        Bundle bundle=new Bundle();
        bundle.putString("message","Counting done..."+time);
        receiver.send(1234,bundle);

    }
}
