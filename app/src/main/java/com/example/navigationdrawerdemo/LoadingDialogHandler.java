package com.example.navigationdrawerdemo;

import android.app.Activity;
import android.view.LayoutInflater;

import androidx.appcompat.app.AlertDialog;

public class LoadingDialogHandler {

    Activity activity;
    AlertDialog alertDialog;

    public LoadingDialogHandler(Activity activity) {
        this.activity = activity;
    }

    void startAlertDialog(){
        AlertDialog.Builder builder =
                new AlertDialog.Builder(activity);
        LayoutInflater layoutInflater =
                activity.getLayoutInflater();
        builder.setView(layoutInflater.inflate(R.layout.startingloadingscreen,null));
        int width = activity.getWindow().getAttributes().width;
        int height = activity.getWindow().getAttributes().height;
//                LayoutParams.MATCH_PARENT;
//        int height = ViewGroup.LayoutParams.MATCH_PARENT;
//        dialog.getWindow().setLayout(width, height);
//        alertDialog.getWindow().setLayout(width,height);

        builder.setCancelable(true);
        alertDialog = builder.create();
        alertDialog.show();
    }
    void stopAlertDialog(){
    alertDialog.dismiss();
    }

}
