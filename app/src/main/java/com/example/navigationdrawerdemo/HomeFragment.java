package com.example.navigationdrawerdemo;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    private Handler mHandler;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home,container,false);


        //HANDLER TO FETCH AND DISPLAY THE RECIPE OF THE DAY
        mHandler = new Handler();
        mHandler.post(runnableService);

        return v;
    }

    //THIS THREAD RUNS WHEN THE HOME PAGE IS LOADED
    //FIRST IT CHECKS IF THE BEARER TOKEN IN AVAILABLE
    //IF IT IS AVAILABLE THEN IT REQUESTS FOR THE RECIPE OF THE DAY API
    //FETCHES THE IMAGE URL FROM JSON RESPONSE RECEIVED
    //THEN THEN IMAGE IS DISPAYED ON THE UI

    private Runnable runnableService = new Runnable() {
        @Override
        public void run() {
            //THIS BEARER_TOKEN_GENERATED_FLAG FLAG IS UPDATED
            //WHEN THE FIRST TIME BEARER TOKEN IS GENERATED
            if(Constants.BEARER_TOKEN_GENERATED_FLAG){
                //call for recipe of the day
                //fetch the image
                //update on UI
                Log.d(Constants.TAG, "run: BEARER TOKEN RECIEVED -> REQUESTING FOR IMAGE");
                return;
            }
                mHandler.postDelayed(runnableService,1*1000);
                Log.d(Constants.TAG, "run: THREAD CHEKING FOR BEARER TOKEN TO FETCH RECIPE OF THE DAY  ");

        }

    };


}
