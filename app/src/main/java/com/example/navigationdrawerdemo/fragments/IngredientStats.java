package com.example.navigationdrawerdemo.fragments;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.navigationdrawerdemo.R;
import com.example.navigationdrawerdemo.util.Constants;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;


public class IngredientStats extends Fragment {

//    int [] yData = Constants.INGREDIENT_COUNTS;
//    String [] xData = Constants.INGREDIENT_NAMES;
//    PieChart pieChart;
    private WebView webView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            ///////////////////////////////////////////////////
        //USING WEBVIEW
        View v = inflater.inflate(R.layout.fragment_ingredient_stats, container, false);
        webView = v.findViewById(R.id.webview);
        webView.setVerticalScrollBarEnabled(true);
        webView.setHorizontalScrollBarEnabled(true);
        webView.requestFocus();
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading Data...");
        progressDialog.setCancelable(false);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setCacheMode( WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if (progress < 100) {
                    progressDialog.show();
                }
                if (progress == 100) {
                    progressDialog.dismiss();
                }
            }
        });
        webView.loadUrl("https://recipedb-androidapplication.herokuapp.com/recipedb_categories_map");//
//        webView.loadUrl("https://recipedb-androidapplication.herokuapp.com/recipedb_ingredientsmap");// PIE CHART
//        webView.loadUrl("https://recipedb-androidapplication.herokuapp.com/recipedb_nutrition_map"); // EARTH

//        webView.addJavascriptInterface(new WebAppInterface(getBaseContext()),"ANDROID");
//        webView.requestFocus();



        ////////////////////////////////////////////////////////////////
        // Inflate the layout for this fragment
//        View v = inflater.inflate(R.layout.fragment_ingredient_stats, container, false);
//        pieChart = v.findViewById(R.id.ingredientPie);
//        pieChart.getDescription().setText("Number of Ingredients across categories");
//        pieChart.setRotation(1f);
//        addDataSet();
//        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
//            @Override
//            public void onValueSelected(Entry e, Highlight h) {
//                Log.d("pie", "onValueSelected: "+e.toString());
//                Log.d("pie", "onValueSelected: "+h.toString());
//                Log.d("pie", "onValueSelected: "+e.toString().substring(17));
////                int pos = Integer.parseInt(h.toString().substring(15,16));
//                Log.d("pie", "onValueSelected: "+pos);
//                Toast.makeText(, "", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected() {
//
//            }
//        });
//        return v;
//    }
//
//    void addDataSet(){
//        ArrayList<PieEntry> yEntries = new ArrayList<>();
//        ArrayList<String> xEntries = new ArrayList<>();
//
//        for(int i=0;i<yData.length;i++){
//            yEntries.add(new PieEntry(yData[i],i));
//        }
//
//        for(int i=0;i<xData.length;i++){
//            xEntries.add(xData[i]);
//        }
//        PieDataSet pieDataSet = new PieDataSet(yEntries,"Count of Ingredient");
//        pieDataSet.setSliceSpace(2f);
//        pieDataSet.setValueTextSize(12f);
//
//        ArrayList<Integer> colors = new ArrayList<>();
//        colors.add(Color.BLUE);
//        colors.add(Color.RED);
//        colors.add(Color.GRAY);
//        colors.add(Color.GREEN);
//        colors.add(Color.MAGENTA);
//        colors.add(Color.CYAN);
//        colors.add(Color.YELLOW);
//        colors.add(Color.BLUE);
//        colors.add(Color.RED);
//        colors.add(Color.GRAY);
//        colors.add(Color.GREEN);
//        colors.add(Color.MAGENTA);
//        colors.add(Color.CYAN);
//        colors.add(Color.YELLOW);
//        colors.add(Color.BLUE);
//        colors.add(Color.RED);
//        colors.add(Color.GRAY);
//        colors.add(Color.GREEN);
//        colors.add(Color.MAGENTA);
//        colors.add(Color.CYAN);
//        colors.add(Color.YELLOW);
//        colors.add(Color.GREEN);
//        colors.add(Color.MAGENTA);
//
//        pieDataSet.setColors(colors);
//
//        Legend legend = pieChart.getLegend();
//        legend.setForm(Legend.LegendForm.CIRCLE);
//        legend.setDirection(Legend.LegendDirection.LEFT_TO_RIGHT);
//
//        PieData pieData = new PieData(pieDataSet);
//        pieChart.setData(pieData);
//        pieChart.invalidate();
        return  v;
    }
}