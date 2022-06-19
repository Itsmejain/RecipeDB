package com.example.navigationdrawerdemo.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.example.navigationdrawerdemo.R;
import com.example.navigationdrawerdemo.util.Constants;


public class IngredientSearchFragment extends Fragment {
    AutoCompleteTextView usedIngredients;
    AutoCompleteTextView notUsedIngredients;
    String[] ingredients = Constants.INGREDIENTS;
    ArrayAdapter<String> ingredientsAdapterItems;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_ingredient_search, container, false);

        usedIngredients = v.findViewById(R.id.usedEditBox);
        notUsedIngredients=v.findViewById(R.id.notUsedEditBox);

        ingredientsAdapterItems = new ArrayAdapter<String>(getContext(),R.layout.region_list,ingredients);
        usedIngredients.setAdapter(ingredientsAdapterItems);
        notUsedIngredients.setAdapter(ingredientsAdapterItems);
        usedIngredients.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                String usedIngredientVal = usedIngredients.getText().toString();
                Toast.makeText(getContext(), "region: "+usedIngredientVal, Toast.LENGTH_SHORT).show();
//                Toast.makeText(getContext(), "selected option: "+i, Toast.LENGTH_SHORT).show();
            }
        });
        notUsedIngredients.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                String notUsedIngredientVal = notUsedIngredients.getText().toString();
                Toast.makeText(getContext(), "region: "+notUsedIngredientVal, Toast.LENGTH_SHORT).show();
//                Toast.makeText(getContext(), "selected option: "+i, Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}