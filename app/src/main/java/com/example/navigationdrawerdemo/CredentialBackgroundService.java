package com.example.navigationdrawerdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class CredentialBackgroundService extends Service {

    public CredentialBackgroundService() {


    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       // Toast.makeText(this, "SERVICE STARTED", Toast.LENGTH_SHORT).show();
        Log.d(Constants.TAG, "CredentialBackgroundService onStartCommand: SERVICE STARTED");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
//        Toast.makeText(this, "SERVICE STOPPPED", Toast.LENGTH_SHORT).show();
        Log.d(Constants.TAG, "CredentialBackgroundService onDestroy: SERVICE STOPPED");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
       return null;
    }
}