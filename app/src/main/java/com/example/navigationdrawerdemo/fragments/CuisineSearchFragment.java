package com.example.navigationdrawerdemo.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.navigationdrawerdemo.R;
import com.example.navigationdrawerdemo.activities.RecipeDetailActivity;
import com.example.navigationdrawerdemo.activities.SearchResultActivity;
import com.example.navigationdrawerdemo.util.Constants;


public class CuisineSearchFragment extends Fragment {

    TextView recipeTitle;
    AutoCompleteTextView region;
    AutoCompleteTextView country;
    Button searchButton;
    String[] regions = Constants.REGIONS;
    String[] countries = Constants.COUNTRIES;
    ArrayAdapter<String> regionAdapterItems;
    ArrayAdapter<String> countryAdapterItems;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v =  inflater.inflate(R.layout.fragment_cuisine_search, container, false);
        searchButton = v.findViewById(R.id.searchButton);
        country = v.findViewById(R.id.countryEditBox);
        recipeTitle=v.findViewById(R.id.recipeEditBox);
        region=v.findViewById(R.id.regionEditBox);
        regionAdapterItems = new ArrayAdapter<String>(getContext(),R.layout.region_list,regions);
        region.setAdapter(regionAdapterItems);
        region.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                String regionVal = region.getText().toString();
                Toast.makeText(getContext(), "region: "+regionVal, Toast.LENGTH_SHORT).show();
//                Toast.makeText(getContext(), "selected option: "+i, Toast.LENGTH_SHORT).show();
            }
        });

        countryAdapterItems = new ArrayAdapter<String>(getContext(),R.layout.country_list,countries);
        country.setAdapter(countryAdapterItems);
        country.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                String countryVal = country.getText().toString();
                Toast.makeText(getContext(), "country: "+countryVal, Toast.LENGTH_SHORT).show();
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String recipeVal=recipeTitle.getText().toString();
                String countryVal = country.getText().toString();
                String regionVal = region.getText().toString();
                if(countryVal.equals("") && recipeVal.equals("")){
                    Intent intent= new Intent(getActivity(), SearchResultActivity.class);
                    intent.putExtra("REQUEST_TYPE","NORMAL_REQUEST");
                    startActivity(intent);
                }
                Log.d("SB", "onClick: "+recipeVal+", "+ countryVal+", "+regionVal);
            }
        });
//        SpannableStringBuilder ssb = new SpannableStringBuilder();
//        ssb.setSpan(new ImageSpan(getActivity(),R.drawable.ic_baseline_analytics_24),ssb.length()-1,ssb.length(),0);
//        ssb.append("Search recipes by their cuisine");
//        ssb.setSpan(new ImageSpan(getActivity(),R.drawable.ic_baseline_analytics_24),ssb.length()-1,ssb.length(),0);
//        String ss =  "Search recipes by their cuisine";
//        textView.setText(ssb);

//        APIHandler apiHandler = new APIHandler();
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