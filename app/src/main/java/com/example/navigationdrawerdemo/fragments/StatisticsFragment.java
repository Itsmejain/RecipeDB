package com.example.navigationdrawerdemo.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.navigationdrawerdemo.R;
import com.example.navigationdrawerdemo.adapter.ViewPageAdapter;
import com.example.navigationdrawerdemo.adapter.ViewPagerAdapterStatistics;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class StatisticsFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("INSIDESTAT", "onCreateView: ????1");
        View v = inflater.inflate(R.layout.fragment_statistics,container,false);
        Log.d("INSIDESTAT", "onCreateView: ????2");
        tabLayout = v.findViewById(R.id.tabLayoutStat);
        viewPager = v.findViewById(R.id.viewpagerStat);

        tabLayout.setupWithViewPager(viewPager);
        ViewPagerAdapterStatistics viewPagerAdapterStatistics = new ViewPagerAdapterStatistics(getChildFragmentManager(),0);
        viewPagerAdapterStatistics.addFragments(new RecipeStats(),"Recipe");
        viewPagerAdapterStatistics.addFragments(new CategoriesStat(),"Categories");
        viewPagerAdapterStatistics.addFragments(new IngredientStats(),"Ingredients");
        viewPagerAdapterStatistics.addFragments(new NutritionStats(),"Nutrition");
        viewPagerAdapterStatistics.addFragments(new ProcessesStats(),"Processes");
        viewPagerAdapterStatistics.addFragments(new UtensilsStats(),"Utensils");
        viewPager.setAdapter(viewPagerAdapterStatistics);
        Log.d("INSIDESTAT", "onCreateView: ????");
//        BottomNavigationView navBar = getActivity().findViewById(R.id.bottom_navigation);
//        navBar.setVisibility(View.VISIBLE);
//        View view = navBar.findViewById(R.id.nav_statistics);
//        view.performClick();
//        navBar.setSelectedItemId(R.id.nav_statistics);
        return v;
    }
}
