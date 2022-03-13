package com.example.navigationdrawerdemo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigationdrawerdemo.model.IngredientSearchFragment;
import com.example.navigationdrawerdemo.R;
import com.example.navigationdrawerdemo.adapter.ViewPageAdapter;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class SearchFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search,container,false);
        tabLayout = v.findViewById(R.id.tabLayout);
        viewPager = v.findViewById(R.id.viewpager);

        tabLayout.setupWithViewPager(viewPager);
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getActivity().getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPageAdapter.addFragments(new CuisineSearchFragment(),"Cuisine Search");
        viewPageAdapter.addFragments(new IngredientSearchFragment(),"Ingredient Search");
        viewPageAdapter.addFragments(new CategorySearchFragment(),"Category Search");
        viewPageAdapter.addFragments(new NutritionSearchFragment(),"Nutrition Search");
        viewPageAdapter.addFragments(new AdvancedSearchFragment(),"Advanced Search");
        viewPager.setAdapter(viewPageAdapter);
        return v;
    }

}
