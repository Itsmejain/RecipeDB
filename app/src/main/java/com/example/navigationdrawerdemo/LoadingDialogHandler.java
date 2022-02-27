package com.example.navigationdrawerdemo;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;

import com.bumptech.glide.Glide;

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
        View v = layoutInflater.inflate(R.layout.startingloadingscreen,null);

        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ImageView imageView = (ImageView)v.findViewById(R.id.imageView_loadingscreen);
        Glide.with(activity).asGif().load(R.raw.foodload).centerCrop().into(imageView);
//        ImageView imageView = (ImageView) findViewById(R.id.imageView);
//        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(imageView);
//        Glide.with(this).load(R.raw.foodload).into(imageViewTarget);


        builder.setView(v);
//        builder.setView(layoutInflater.inflate(R.layout.startingloadingscreen,null));
        int width = activity.getWindow().getAttributes().width;
        int height = activity.getWindow().getAttributes().height;
//                LayoutParams.MATCH_PARENT;
//        int height = ViewGroup.LayoutParams.MATCH_PARENT;
//        dialog.getWindow().setLayout(width, height);
//        alertDialog.getWindow().setLayout(width,height);

        builder.setCancelable(true);
        alertDialog = builder.create();
        alertDialog.show();
        class MyRunnable implements Runnable {

            @Override
            public void run() {
                alertDialog.hide();
            }
        }
        Runnable r = new MyRunnable();
        Handler handler = new Handler();
        handler.postDelayed(r,7*1000);
    }
    void stopAlertDialog(){
    alertDialog.dismiss();
    }

}
