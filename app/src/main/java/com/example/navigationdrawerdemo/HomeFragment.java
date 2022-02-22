package com.example.navigationdrawerdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import retrofit2.Response;

public class HomeFragment extends Fragment {
    private Handler mHandler;
    private ImageView recipeOfTheDayImageView;
    private TextView recipeOfTheDay_Name_TextView;
    private JsonObject recipeOfTheDay;
    private RecipeDetails recipeDetails;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home,container,false);
        recipeOfTheDayImageView = v.findViewById(R.id.imageView_recipeofhtheday);
        recipeOfTheDay_Name_TextView = v.findViewById(R.id.textView_recipe_of_the_day_name);

        //HANDLER TO FETCH AND DISPLAY THE RECIPE OF THE DAY
        mHandler = new Handler();
        mHandler.post(runnableService);


        //RECIVE LOCAL BROADCAST
        initBroadCastReceiver();

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
                APIHandler apiHandler = new APIHandler(getContext());
                recipeOfTheDay = apiHandler.recipeOfTheDay();
              //  Response<JsonObject>  recipeOfTheDay2 = apiHandler.recipeOfTheDay();

//                Object keyvalue = recipeOfTheDay.get("_id");

//                JsonElement imgUrl = recipeOfTheDay.get("_id");
//                String imgUrlString = imgUrl.toString();
//                Log.d(Constants.TAG, "run: IMAGE URL RECIPE OF THE DAY :"+recipeOfTheDay2.body());
                return;
            }
                mHandler.postDelayed(runnableService,1*1000);
                Log.d(Constants.TAG, "run: THREAD CHEKING FOR BEARER TOKEN TO FETCH RECIPE OF THE DAY  ");

        }

    };

    private void initBroadCastReceiver() {
        LocalBroadcastManager manager = LocalBroadcastManager.getInstance(getContext());
        MyBroadCastReceiver receiver = new MyBroadCastReceiver();
        IntentFilter filter = new IntentFilter();
        //whatever
        filter.addAction("com.example.navigationdrawerdemo");
        manager.registerReceiver(receiver,filter);
    }
    class MyBroadCastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
             recipeDetails = intent.getParcelableExtra("RECIPEOFTHEDAY");
            Log.d(Constants.TAG, "onReceive: MyBroadCastReceiver "+recipeDetails.getImg_url());
            recipeOfTheDay_Name_TextView.setText(recipeDetails.getRecipe_title());
            new DownloadImage(recipeOfTheDayImageView).execute(recipeDetails.getImg_url());
//                    DownloadImageTask((ImageView) newsImageView,getContext()).execute(newsResponse.getImageurl());
        }
    }
}
