package com.example.navigationdrawerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class RecipeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        Intent intent = getIntent();
        String requestType = intent.getStringExtra("REQUEST_TYPE");
        Log.d(Constants.TAG, "onCreate: REQUEST TYPE :"+requestType);
        RecipeDetailFragment recipeDetailFragment = new RecipeDetailFragment();
        Bundle bundle = new Bundle();
        if(requestType.equalsIgnoreCase("RECIPEOFTHEDAY")){
            bundle.putString("REQUEST_TYPE","RECIPEOFTHEDAY");

        }else{
            bundle.putString("REQUEST_TYPE","NORMAL_REQUEST");
        }
        recipeDetailFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,recipeDetailFragment).addToBackStack("RDB").commit();
    }
}