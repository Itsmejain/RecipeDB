package com.example.navigationdrawerdemo;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class RecipeDetailFragment extends Fragment {
    ImageView recipeImage;
    TextView recipeTitle;
    private RecipeDetails recipeDetails;
    private JsonObject recipeOfTheDay;
    LoadingDialogHandler loadingDialogHandler;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        String REQUEST_TYPE = bundle.getString("REQUEST_TYPE");
        Toast.makeText(getContext(), "REQUEST_TYPE::"+REQUEST_TYPE, Toast.LENGTH_SHORT).show();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipe_detail, container, false);
        recipeImage = view.findViewById(R.id.recipeImage);
        recipeTitle = view.findViewById(R.id.recipeTitle);
        //RECIVE LOCAL BROADCAST
        initBroadCastReceiver();

        loadingDialogHandler = new LoadingDialogHandler(getActivity());
        loadingDialogHandler.startAlertDialog();

        if(REQUEST_TYPE.equalsIgnoreCase("RECIPEOFTHEDAY")){
//        new RecipeOfTheDayFetchTask(recipeImage,recipeTitle,loadingDialogHandler).execute();
            APIHandler apiHandler = new APIHandler(getContext());
            recipeOfTheDay = apiHandler.recipeOfTheDay(loadingDialogHandler);
        }



        return view;
    }


    private void initBroadCastReceiver() {
        LocalBroadcastManager manager = LocalBroadcastManager.getInstance(getContext());
        MyBroadCastReceiver receiver = new MyBroadCastReceiver();
        IntentFilter filter = new IntentFilter();
        //whatever
        filter.addAction("com.example.navigationdrawerdemo");
        manager.registerReceiver(receiver,filter);
    }
    class MyBroadCastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(Constants.TAG, "onReceive: LOCAL BROADCAST RECIEVED");
            recipeDetails = intent.getParcelableExtra("RECIPEOFTHEDAY");
            Log.d(Constants.TAG, "onReceive: MyBroadCastReceiver "+recipeDetails.getImg_url());
            updateDataOnUI(recipeDetails);




            //   new DownloadImage(recipeOfTheDayImageView).execute(recipeDetails.getImg_url());
//                    DownloadImageTask((ImageView) newsImageView,getContext()).execute(newsResponse.getImageurl());
        }
    }

    private void updateDataOnUI(RecipeDetails recipeDetails){
        recipeTitle.setText(recipeDetails.getRecipe_title());
        if(getActivity()!=null ){
                Glide.with(getActivity())
                        .load(recipeDetails.getImg_url())
                        .placeholder(R.drawable.ic_launcher_background)
                        .addListener(new RequestListener<Drawable>() {
                            @Override
                            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                                loadingDialogHandler.stopAlertDialog();
                                return false;
                            }

                            @Override
                            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                loadingDialogHandler.stopAlertDialog();
                                return false;
                            }
                        }).into(recipeImage);

            }


        Constants.RECIPE_OF_THE_DAY_IMAGE_DOWNLOADED = true;
        Constants.RECIPE_OF_THE_DAY_IMAGE_URL = recipeDetails.getImg_url();

    }
}
