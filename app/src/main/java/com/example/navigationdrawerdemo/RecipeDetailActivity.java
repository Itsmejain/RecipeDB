package com.example.navigationdrawerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RecipeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new RecipeDetailFragment()).commit();
    }
}