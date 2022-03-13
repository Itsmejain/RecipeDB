package com.example.navigationdrawerdemo.util;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.example.navigationdrawerdemo.retrofit.APIHandler;

public class CredentialBackgroundService extends Service {
    private Handler mHandler;

    public boolean isServiceRunning = false;
    private Runnable runnableService = new Runnable() {
        @Override
        public void run() {
            // Repeat this runnable code block again every ... min
            if(isServiceRunning){
                if(checkInternetConnection()){
                    APIHandler apiHandler = new APIHandler();

//                    apiHandler.postRequestRecipe();
                    apiHandler.bearerTokenGenerator();
                }else{
                    Toast.makeText(getBaseContext(), "NO INTERNET CONNECTION", Toast.LENGTH_LONG).show();
                }
                mHandler.postDelayed(runnableService, Constants.BEARER_TOKEN_REFRESH_TIME);
                Log.d(Constants.TAG, "run: RUNNABLE RUNNING ");
            }else{
                return;
            }
            //Toast.makeText(ServiceHandler.this, "", Toast.LENGTH_SHORT).show();
//            Log.d(TAG, "run: THREAD RUNNING ");
        }

    };
    public CredentialBackgroundService() {


    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       // Toast.makeText(this, "SERVICE STARTED", Toast.LENGTH_SHORT).show();
        isServiceRunning = true;
        Log.d(Constants.TAG, "CredentialBackgroundService onStartCommand: SERVICE STARTED");

        //THIS THREAD IS FOR BEARER TOKEN GENERATION
        //WHICH KEEPS RUNNING IN BACKGROUND
        //AND KEEPS UPDATING THE BEARER TOKEN BEFORE IT EXPIRES
        mHandler = new Handler();
        mHandler.post(runnableService);
        return START_STICKY;

    }

    @Override
    public void onDestroy() {
        isServiceRunning = false;
//        Toast.makeText(this, "SERVICE STOPPPED", Toast.LENGTH_SHORT).show();
        Log.d(Constants.TAG, "CredentialBackgroundService onDestroy: SERVICE STOPPED");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
       return null;
    }

    public  boolean checkInternetConnection(){
        ConnectivityManager connMng = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMng.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }

}