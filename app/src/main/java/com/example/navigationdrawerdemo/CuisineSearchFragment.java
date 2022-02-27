package com.example.navigationdrawerdemo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class CuisineSearchFragment extends Fragment {

    TextView textView ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v =  inflater.inflate(R.layout.fragment_cuisine_search, container, false);
        textView = v.findViewById(R.id.cuisineSearchTextView);

        APIHandler apiHandler = new APIHandler();
//        String s = apiHandler.getRecipeBySubregion("Bangladeshi",textView);
//        String s = apiHandler.getRecipeByRegion("Middle Eastern",textView);
//        String s = apiHandler.getIngredientsByRecipe(2610,textView);
//        String s = apiHandler.searchIngredient("dungeness",textView);
        String s = apiHandler.searchIngredientNutrition("dungeness",textView);
        Log.d(Constants.TAG, "onCreateView: CUISINE SEATCH  "+s);
        textView.setText(s);
        return v;
    }
}