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

public class AdvancedSearchFragment extends Fragment {

    ArrayAdapter<String> regionAdapterItems;
    ArrayAdapter<String> countryAdapterItems;
    ArrayAdapter<String> continentAdapterItems;
    ArrayAdapter<String> utensilsAdapterItems;
    ArrayAdapter<String> processAdapterItems;
    AutoCompleteTextView country ;
    AutoCompleteTextView region;
    AutoCompleteTextView continent;
    AutoCompleteTextView utensil;
    AutoCompleteTextView process;
    String[] regions = Constants.REGIONS;
    String[] countries = Constants.COUNTRIES;
    String[] continents = Constants.CONTINENTS;
    String [] utensils = Constants.UTENSIL_NAMES;
    String [] processes = Constants.PROCESS_NAMES;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_advanced_search, container, false);
        continent = v.findViewById(R.id.advcontinentEditBox);
        country = v.findViewById(R.id.advCountryEditBox);
        region = v.findViewById(R.id.advRegionEditBox);
        utensil = v.findViewById(R.id.utensilEditBox);
        process = v.findViewById(R.id.cookingEditBox);


        regionAdapterItems = new ArrayAdapter<String>(getContext(),R.layout.region_list,regions);
        countryAdapterItems = new ArrayAdapter<String>(getContext(),R.layout.region_list,countries);
        continentAdapterItems = new ArrayAdapter<String>(getContext(),R.layout.region_list,continents);
        utensilsAdapterItems = new ArrayAdapter<String>(getContext(),R.layout.region_list,utensils);
        processAdapterItems = new ArrayAdapter<String>(getContext(),R.layout.region_list,processes);
        region.setAdapter(regionAdapterItems);
        country.setAdapter(countryAdapterItems);
        continent.setAdapter(continentAdapterItems);
        utensil.setAdapter(utensilsAdapterItems);
        process.setAdapter(processAdapterItems);

        utensil.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                String utensilVal = utensil.getText().toString();
                Toast.makeText(getContext(), "region: "+utensilVal, Toast.LENGTH_SHORT).show();
            }
        });

        process.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                String processVal = process.getText().toString();
                Toast.makeText(getContext(), "region: "+processVal, Toast.LENGTH_SHORT).show();
            }
        });

        region.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                String regionVal = region.getText().toString();
                Toast.makeText(getContext(), "region: "+regionVal, Toast.LENGTH_SHORT).show();
            }
        });

        country.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                String countryVal = country.getText().toString();
                Toast.makeText(getContext(), "region: "+countryVal, Toast.LENGTH_SHORT).show();
            }
        });

        continent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                String continentVal = continent.getText().toString();
                Toast.makeText(getContext(), "region: "+continentVal, Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}