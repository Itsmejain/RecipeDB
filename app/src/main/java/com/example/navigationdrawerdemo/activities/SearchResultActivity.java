package com.example.navigationdrawerdemo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.navigationdrawerdemo.R;
import com.example.navigationdrawerdemo.fragments.SearchResult;

public class SearchResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,new SearchResult()).commit();
    }
}