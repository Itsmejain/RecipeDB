package com.example.navigationdrawerdemo.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.navigationdrawerdemo.util.Constants;
import com.example.navigationdrawerdemo.util.LoadingDialogHandler;
import com.example.navigationdrawerdemo.R;
import com.example.navigationdrawerdemo.activities.RecipeDetailActivity;
import com.example.navigationdrawerdemo.activities.SummaryActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NewHomeFragment extends Fragment {
    private Handler mHandler;
    ////    private ImageView recipeOfTheDayImageView;
////    private TextView recipeOfTheDay_Name_TextView;
//    private JsonObject recipeOfTheDay;
//    private RecipeDetails recipeDetails;
//    private ImageButton imageButtonSummary;
    CardView CardButton_summary;
    CardView CardButton_statistics;

    CardView CardButton_recipeOfDay;

    CardView CardButton_textsearch;
    CardView CardButton_visualsearch;
    CardView CardButton_cosylabs;
    CardView CardButton_contactus;

    ProgressDialog pDialog;
    LoadingDialogHandler loadingDialogHandler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.newhomefragment, container, false);//old fragment
        CardButton_summary = v.findViewById(R.id.CardButton_summary);
        CardButton_statistics = v.findViewById(R.id.CardButton_statistics);

        CardButton_recipeOfDay = v.findViewById(R.id.CardButton_recipeOfDay);


        CardButton_textsearch = v.findViewById(R.id.CardButton_textsearch);
        CardButton_visualsearch = v.findViewById(R.id.CardButton_visualsearch);
        CardButton_cosylabs = v.findViewById(R.id.CardButton_cosylabs);
        CardButton_contactus = v.findViewById(R.id.CardButton_contactus);


        CardButton_summary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "SUMMARY CLICKED", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), SummaryActivity.class);
                startActivity(intent);

            }
        });
        CardButton_statistics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "SUMMARY CLICKED", Toast.LENGTH_SHORT).show();
                if(getActivity()!=null){
                    BottomNavigationView navBar = getActivity().findViewById(R.id.bottom_navigation);
                    navBar.setVisibility(View.VISIBLE);
                    View vi = navBar.findViewById(R.id.nav_statistics);
                    vi.performClick();
                }

            }
        });


       CardButton_recipeOfDay.setOnClickListener(new View.OnClickListener() {
                                                      @Override
                                                      public void onClick(View view) {
//                                                          Bundle bundle = new Bundle();
//                                                          bundle.putString("REQUEST_TYPE","RECIPEOFTHEDAY");
                                                          Intent intent= new Intent(getActivity(), RecipeDetailActivity.class);
                                                          intent.putExtra("REQUEST_TYPE","RECIPEOFTHEDAY");
                                                          startActivity(intent);

                                                      }
                                                  });
          
          CardButton_textsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "TEXT SEARCH CLICKED", Toast.LENGTH_SHORT).show();
                if(getActivity()!=null){
                    BottomNavigationView navBar = getActivity().findViewById(R.id.bottom_navigation);
                    navBar.setVisibility(View.VISIBLE);
                    View vi = navBar.findViewById(R.id.nav_search);
                    vi.performClick();
                }
            }
        });
        CardButton_visualsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "TEXT SEARCH CLICKED", Toast.LENGTH_SHORT).show();
                if(getActivity()!=null){
                    BottomNavigationView navBar = getActivity().findViewById(R.id.bottom_navigation);
                    navBar.setVisibility(View.VISIBLE);
                    View vi = navBar.findViewById(R.id.nav_visual_search);
                    vi.performClick();
                }
            }
        });
        CardButton_cosylabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "COSYLABS CLICKED", Toast.LENGTH_SHORT).show();
                if(getActivity()!=null){

                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container,new CosylabsFragment())
                            .addToBackStack("rdb")
                            .commit();
//                    BottomNavigationView navBar = getActivity().findViewById(R.id.bottom_navigation);
//                    navBar.setVisibility(View.VISIBLE);
//                    View vi = navBar.findViewById(R.id.nav_search);
//                    vi.performClick();
                }
            }
        });
        CardButton_contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "CONTACT US CLICKED", Toast.LENGTH_SHORT).show();
                if(getActivity()!=null){
//                    BottomNavigationView navBar = getActivity().findViewById(R.id.bottom_navigation);
//                    navBar.setVisibility(View.VISIBLE);
//                    View vi = navBar.findViewById(R.id.nav_search);
//                    vi.performClick();
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container,new ContactUsFragment())
                            .addToBackStack("rdb")
                            .commit();
                }

            }
        });

        BottomNavigationView navBar = getActivity().findViewById(R.id.bottom_navigation);
        navBar.setVisibility(View.GONE);

//        recipeOfTheDayImageView = v.findViewById(R.id.imageView_recipeofhtheday);
//        recipeOfTheDay_Name_TextView = v.findViewById(R.id.textView_recipe_of_the_day_name);
//        imageButtonSummary = v.findViewById(R.id.imageButtonSummary);

//        if(Constants.RECIPE_OF_THE_DAY_IMAGE_DOWNLOADED){
//            Glide.with(getActivity())
//                    .load(Constants.RECIPE_OF_THE_DAY_IMAGE_URL)
//                    .placeholder(R.drawable.ic_launcher_background)//.transform(new CircleCrop())
//                    .into(recipeOfTheDayImageView);
//        }

//        imageButtonSummary.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getContext(),SummaryActivity.class);
//                startActivity(intent);
//            }
//        });
        //HANDLER TO FETCH AND DISPLAY THE RECIPE OF THE DAY
//        if(!Constants.RECIPE_OF_THE_DAY_IMAGE_DOWNLOADED) {
//         pDialog = new ProgressDialog(getContext());
//         pDialog.setContentView(R.layout.startingloadingscreen);
//        pDialog.setView((View) R.layout.startingloadingscreen);
//        pDialog.setMessage("Loading...PLease wait");
//        pDialog.show();
        loadingDialogHandler =
                new LoadingDialogHandler(getActivity());

        //ADD SPLASH SCREEN HERE

        loadingDialogHandler.startAlertDialog();
        mHandler = new Handler();
        mHandler.post(runnableService);
//        }

        //RECIVE LOCAL BROADCAST
//        initBroadCastReceiver();

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
//            //THIS BEARER_TOKEN_GENERATED_FLAG FLAG IS UPDATED
//            //WHEN THE FIRST TIME BEARER TOKEN IS GENERATED
            if (Constants.BEARER_TOKEN_GENERATED_FLAG) {
                loadingDialogHandler.stopAlertDialog();
            }
            mHandler.postDelayed(runnableService, 2 * 1000);
        }
    };
}
//            mHandler.post(runnableService);
////                mHandler.post(runnableService);
//                //call for recipe of the day
//                //fetch the image
//                //update on UI
//                Log.d(Constants.TAG, "run: BEARER TOKEN RECIEVED -> REQUESTING FOR IMAGE");
////                APIHandler apiHandler = new APIHandler(getContext());
////                recipeOfTheDay = apiHandler.recipeOfTheDay(loadingDialogHandler);
////              //  Response<JsonObject>  recipeOfTheDay2 = apiHandler.recipeOfTheDay();
//
////                Object keyvalue = recipeOfTheDay.get("_id");
//
////                JsonElement imgUrl = recipeOfTheDay.get("_id");
////                String imgUrlString = imgUrl.toString();
////                Log.d(Constants.TAG, "run: IMAGE URL RECIPE OF THE DAY :"+recipeOfTheDay2.body());
//                return;
//            }else{
//             //   loadingDialogHandler.stopAlertDialog();
//            }
//                mHandler.postDelayed(runnableService,5*1000);
////                mHandler.post(runnableService);
//                Log.d(Constants.TAG, "run: THREAD CHEKING FOR BEARER TOKEN TO FETCH RECIPE OF THE DAY  ");
//
//        }
//
//    };
//
//    private void initBroadCastReceiver() {
//        LocalBroadcastManager manager = LocalBroadcastManager.getInstance(getContext());
//        MyBroadCastReceiver receiver = new MyBroadCastReceiver();
//        IntentFilter filter = new IntentFilter();
//        //whatever
//        filter.addAction("com.example.navigationdrawerdemo");
//        manager.registerReceiver(receiver,filter);
//    }
//    class MyBroadCastReceiver extends BroadcastReceiver{
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//             recipeDetails = intent.getParcelableExtra("RECIPEOFTHEDAY");
//            Log.d(Constants.TAG, "onReceive: MyBroadCastReceiver "+recipeDetails.getImg_url());
//            recipeOfTheDay_Name_TextView.setText(recipeDetails.getRecipe_title());
//            if(getActivity()!=null ){
//            Glide.with(getActivity())
//                    .load(recipeDetails.getImg_url())
//                    .placeholder(R.drawable.ic_launcher_background)
//                    .into(recipeOfTheDayImageView);
//            }
//
//            Constants.RECIPE_OF_THE_DAY_IMAGE_DOWNLOADED = true;
//            Constants.RECIPE_OF_THE_DAY_IMAGE_URL = recipeDetails.getImg_url();
//            //   new DownloadImage(recipeOfTheDayImageView).execute(recipeDetails.getImg_url());
////                    DownloadImageTask((ImageView) newsImageView,getContext()).execute(newsResponse.getImageurl());
//        }
//    }
//}
