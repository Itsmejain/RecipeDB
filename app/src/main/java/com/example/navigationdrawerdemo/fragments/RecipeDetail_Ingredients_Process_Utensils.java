package com.example.navigationdrawerdemo.fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.navigationdrawerdemo.util.LoadingDialogHandler;
import com.example.navigationdrawerdemo.R;
import com.example.navigationdrawerdemo.model.RecipeDetails;
import com.example.navigationdrawerdemo.util.Constants;

public class RecipeDetail_Ingredients_Process_Utensils extends Fragment {
    ImageView recipeImage;
    TextView recipeTitle;
    TextView EditText_processes;
    TextView EditText_utensils;
//    TextView EditText_fats;
//    TextView EditText_carbs;
//    TextView EditText_protein;

    private RecipeDetails recipeDetails;
//    private JsonObject recipeOfTheDay;
    LoadingDialogHandler loadingDialogHandler;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe_detail_process_utensils, container, false);
//        loadingDialogHandler.startAlertDialog();
        Bundle bundle = getArguments();
        recipeDetails = bundle.getParcelable("RecipeDetailsJson");

//        String

//        Toast.makeText(getContext(), "Cuisine::"+cuisine, Toast.LENGTH_SHORT).show();
//        Log.d(Constants.TAG, " RecipeDetail_RecipeOverview_Fragment onCreateView:Cuisine "+cuisine + recipeDetails.getImg_url());
        // Inflate the layout for this fragment


        recipeImage = view.findViewById(R.id.recipeImage);
        recipeTitle = view.findViewById(R.id.recipeTitle);
        EditText_processes = view.findViewById(R.id.EditText_processes);
        EditText_utensils = view.findViewById(R.id.EditText_utensils);

        if(getActivity()!=null ){
            Glide.with(getActivity())
                    .load(recipeDetails.getImg_url())
                    .placeholder(R.drawable.ic_launcher_background)
                    .addListener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        //    loadingDialogHandler.stopAlertDialog();
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                         //   loadingDialogHandler.stopAlertDialog();
                            return false;
                        }
                    }).into(recipeImage);

        }
        recipeTitle.setText(recipeDetails.getRecipe_title());

        String processes = recipeDetails.getProcesses();
        String[] tokens = processes.split("\\|\\|");
        Log.d(Constants.TAG, "onCreateView: TOKENS "+tokens);
//        Log.d(Constants.TAG, "onCreateView: strFields "+strFields);
        String allprocesses = "";
        for(String x:tokens){
            allprocesses = allprocesses+x;
            allprocesses = allprocesses+"\n";
            Log.d(Constants.TAG, "onCreateView: "+x);
        }
        EditText_processes.setText(allprocesses);

        String utensils = recipeDetails.getUtensils();
        EditText_utensils.setText(utensils);


//        //RECIVE LOCAL BROADCAST
//        initBroadCastReceiver();
//
//        loadingDialogHandler = new LoadingDialogHandler(getActivity());
//        loadingDialogHandler.startAlertDialog();
//
//        if(REQUEST_TYPE.equalsIgnoreCase("RECIPEOFTHEDAY")){
////        new RecipeOfTheDayFetchTask(recipeImage,recipeTitle,loadingDialogHandler).execute();
//            APIHandler apiHandler = new APIHandler(getContext());
//            recipeOfTheDay = apiHandler.recipeOfTheDay(loadingDialogHandler);
//        }



        return view;
    }


//    private void initBroadCastReceiver() {
//        LocalBroadcastManager manager = LocalBroadcastManager.getInstance(getContext());
//        MyBroadCastReceiver receiver = new MyBroadCastReceiver();
//        IntentFilter filter = new IntentFilter();
//        //whatever
//        filter.addAction("com.example.navigationdrawerdemo");
//        manager.registerReceiver(receiver,filter);
//    }
//    class MyBroadCastReceiver extends BroadcastReceiver {
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            Log.d(Constants.TAG, "onReceive: LOCAL BROADCAST RECIEVED");
//            recipeDetails = intent.getParcelableExtra("RECIPEOFTHEDAY");
//
//            Log.d(Constants.TAG, "onReceive: MyBroadCastReceiver "+recipeDetails.getImg_url());
//            updateDataOnUI(recipeDetails);
//
//
//
//
//            //   new DownloadImage(recipeOfTheDayImageView).execute(recipeDetails.getImg_url());
////                    DownloadImageTask((ImageView) newsImageView,getContext()).execute(newsResponse.getImageurl());
//        }
//    }
//
//    @SuppressLint("SetTextI18n")
//    private void updateDataOnUI(RecipeDetails recipeDetails){
//        recipeTitle.setText(recipeDetails.getRecipe_title());
//        EditText_energykcal.setText(EditText_energykcal.getText() + " " + recipeDetails.getEnergykcal());
//        EditText_fats.setText(EditText_fats.getText() + " " + recipeDetails.getTotallipidfat());
//        EditText_carbs.setText(EditText_carbs.getText() + " " + recipeDetails.getCarbohydratebydifference());
//        EditText_protein.setText(EditText_protein.getText() + " " + recipeDetails.getProtein());
//        if(getActivity()!=null ){
//                Glide.with(getActivity())
//                        .load(recipeDetails.getImg_url())
//                        .placeholder(R.drawable.ic_launcher_background)
//                        .addListener(new RequestListener<Drawable>() {
//                            @Override
//                            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//                                loadingDialogHandler.stopAlertDialog();
//                                return false;
//                            }
//
//                            @Override
//                            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//                                loadingDialogHandler.stopAlertDialog();
//                                return false;
//                            }
//                        }).into(recipeImage);
//
//            }
//
//
//        Constants.RECIPE_OF_THE_DAY_IMAGE_DOWNLOADED = true;
//        Constants.RECIPE_OF_THE_DAY_IMAGE_URL = recipeDetails.getImg_url();
//
//    }
}
