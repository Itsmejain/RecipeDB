package com.example.navigationdrawerdemo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;


public class CuisineSearchFragment extends Fragment {

    TextView textView ;
    String[] regions = {"Australian",
            "Belgian",
            "Canadian",
            "Caribbean",
            "Central American",
            "Chinese and Mongolian",
            "Deutschland",
            "Eastern European",
            "French",
            "Greek",
            "Indian Subcontinent",
            "Irish",
            "Italian",
            "Japanese",
            "Korean",
            "Mexican",
            "Middle Eastern",
            "Northern Africa",
            "Rest Africa",
            "Scandinavian",
            "South American",
            "Southeast Asian",
            "Spanish and Portuguese",
            "Thai",
            "UK"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v =  inflater.inflate(R.layout.fragment_cuisine_search, container, false);
        textView = v.findViewById(R.id.cuisineSearchTextView);
        autoCompleteTextView=v.findViewById(R.id.regionEditBox);
        adapterItems = new ArrayAdapter<String>(getContext(),R.layout.region_list,regions);
        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                String regionVal = autoCompleteTextView.getText().toString();
                Toast.makeText(getContext(), "region: "+regionVal, Toast.LENGTH_SHORT).show();
//                Toast.makeText(getContext(), "selected option: "+i, Toast.LENGTH_SHORT).show();
            }
        });
//        SpannableStringBuilder ssb = new SpannableStringBuilder();
//        ssb.setSpan(new ImageSpan(getActivity(),R.drawable.ic_baseline_analytics_24),ssb.length()-1,ssb.length(),0);
//        ssb.append("Search recipes by their cuisine");
//        ssb.setSpan(new ImageSpan(getActivity(),R.drawable.ic_baseline_analytics_24),ssb.length()-1,ssb.length(),0);
//        String ss =  "Search recipes by their cuisine";
//        textView.setText(ssb);

        APIHandler apiHandler = new APIHandler();
//        String s = apiHandler.getRecipeBySubregion("Bangladeshi",textView);
//        String s = apiHandler.getRecipeByRegion("Middle Eastern",textView);
//        String s = apiHandler.getIngredientsByRecipe(2610,textView);
//        String s = apiHandler.searchIngredient("dungeness",textView);
//        String s = apiHandler.searchIngredientNutrition("dungeness",textView);
//        Log.d(Constants.TAG, "onCreateView: CUISINE SEATCH  "+s);
//        textView.setText(s);
        return v;
    }
}