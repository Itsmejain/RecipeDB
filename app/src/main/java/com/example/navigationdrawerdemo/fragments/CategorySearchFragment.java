package com.example.navigationdrawerdemo.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.navigationdrawerdemo.R;
import com.example.navigationdrawerdemo.util.Constants;

public class CategorySearchFragment extends Fragment {

    Button searchButton;
    AutoCompleteTextView ingredientUsed;
    AutoCompleteTextView ingredientNotUsed;
    String [] ingredientCategories = Constants.INGREDIENT_CATEGORIES;
    ArrayAdapter<String> ingredientAdapterItems;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_category_search, container, false);
        searchButton = v.findViewById(R.id.searchByCategory);
        ingredientUsed = v.findViewById(R.id.usedCategoryEditBox);
        ingredientNotUsed = v.findViewById(R.id.notUsedCategoryEditBox);
        ingredientAdapterItems = new ArrayAdapter<String>(getContext(),R.layout.region_list,ingredientCategories);
        ingredientUsed.setAdapter(ingredientAdapterItems);
        ingredientUsed.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                String ingredientVal = ingredientUsed.getText().toString();
                Toast.makeText(getContext(), "$ingredientVal", Toast.LENGTH_SHORT).show();
            }
        });

        ingredientNotUsed.setAdapter(ingredientAdapterItems);
        ingredientNotUsed.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                String ingredientVal = ingredientUsed.getText().toString();
                Toast.makeText(getContext(), "$ingredientVal", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}