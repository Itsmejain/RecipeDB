package com.example.navigationdrawerdemo.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationdrawerdemo.R;
import com.example.navigationdrawerdemo.adapter.SearchResultAdapter;
import com.example.navigationdrawerdemo.model.RecipeDetails;
import com.example.navigationdrawerdemo.util.Constants;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class SearchResult extends Fragment {
    RecyclerView recyclerView;
    ArrayList<RecipeDetails> searchResultList = new ArrayList<>();
    RecipeDetails recipeDetails;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_search_result, container, false);
        recyclerView=v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        String recipejson = Constants.dummyRecipe;

        try {
            JSONObject jsonObject = new JSONObject(recipejson);
            Gson gson = new Gson();
            recipeDetails = gson.fromJson(String.valueOf(jsonObject),RecipeDetails.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        searchResultList.add(recipeDetails);
        searchResultList.add(recipeDetails);
        searchResultList.add(recipeDetails);
        searchResultList.add(recipeDetails);
        // {recipeDetails,recipeDetails,recipeDetails,recipeDetails};
        recyclerView.setAdapter(new SearchResultAdapter(searchResultList));
        return v;
    }
}