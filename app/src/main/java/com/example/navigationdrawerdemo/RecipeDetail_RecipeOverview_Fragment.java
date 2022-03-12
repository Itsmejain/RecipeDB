package com.example.navigationdrawerdemo;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.gson.JsonObject;

public class RecipeDetail_RecipeOverview_Fragment extends Fragment {
    ImageView recipeImage;
    TextView recipeTitle;
    TextView EditText_cuisine;
    TextView EditText_source;
//    TextView EditText_fats;
//    TextView EditText_carbs;
//    TextView EditText_protein;

    private RecipeDetails recipeDetails;
//    private JsonObject recipeOfTheDay;
    LoadingDialogHandler loadingDialogHandler;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe_detail_recipe_overview, container, false);
//        loadingDialogHandler.startAlertDialog();
        Bundle bundle = getArguments();
         recipeDetails = bundle.getParcelable("RecipeDetailsJson");

        String continent = recipeDetails.getContinent();
        String subregion = recipeDetails.getSub_region();
        String region = recipeDetails.getRegion();
        String cuisine = "Continent : "+continent+"\n"
                +"Region : "+region+"\n"
                +"Sub Region : "+subregion;
        String source = recipeDetails.getSource();
        String sourceUrl = recipeDetails.getUrl();

//        Toast.makeText(getContext(), "Cuisine::"+cuisine, Toast.LENGTH_SHORT).show();
        Log.d(Constants.TAG, " RecipeDetail_RecipeOverview_Fragment onCreateView:Cuisine "+cuisine + recipeDetails.getImg_url());
        // Inflate the layout for this fragment


        recipeImage = view.findViewById(R.id.recipeImage);
        recipeTitle = view.findViewById(R.id.recipeTitle);
        EditText_cuisine = view.findViewById(R.id.EditText_cuisine);
        EditText_source = view.findViewById(R.id.EditText_source);

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
        EditText_cuisine.setText(cuisine);

//        EditText_source.setText(sourceUrl);
        EditText_source.setClickable(true);
        String sourceText = "<a href='"+sourceUrl+"'>"+source+"</a>";

//        textView.setClickable(true);
        EditText_source.setMovementMethod(LinkMovementMethod.getInstance());
//        String text = "<a href='http://www.google.com'> Google </a>";
//        EditText_source.setLinkTextColor();
        EditText_source.setText(Html.fromHtml(sourceText));
//
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
