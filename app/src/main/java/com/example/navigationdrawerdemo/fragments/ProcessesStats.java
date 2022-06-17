package com.example.navigationdrawerdemo.fragments;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.navigationdrawerdemo.R;
import com.example.navigationdrawerdemo.util.Constants;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;


public class ProcessesStats extends Fragment {

    //    int [] yData = Constants.PROCESS_COUNTS;
//    String [] xData = Constants.PROCESS_NAMES;
//    PieChart pieChart;

    private WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_processes_stats, container, false);
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
        webView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
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

        //        webView.loadUrl("https://recipedb-androidapplication.herokuapp.com/recipedb_recipes_map");// RECIPES MAP
        //        webView.loadUrl("https://recipedb-androidapplication.herokuapp.com/recipedb_categories_map");// CATEGORIES MAP
        //        webView.loadUrl("https://recipedb-androidapplication.herokuapp.com/recipedb_ingredientsmap");// INGREDIENTS CHART
//        webView.loadUrl("https://recipedb-androidapplication.herokuapp.com/recipedb_nutrition_map");// NUTRITION CHART
                webView.loadUrl("https://recipedb-androidapplication.herokuapp.com/recipedb_processes_map");// PROCESSES CHART
        //        webView.loadUrl("https://recipedb-androidapplication.herokuapp.com/recipedb_utensils_map");//UTENSILS CHART


//        webView.addJavascriptInterface(new WebAppInterface(getBaseContext()),"ANDROID");
//        webView.requestFocus();

        return v;
    }
}
    //////////////////////////////////////////////////////////////////////////////////////////////////

//        pieChart = v.findViewById(R.id.processesPie);
//        pieChart.getDescription().setText("Unique Process across recipes");
//        pieChart.setRotation(1f);
//        addDataSet();
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
//        PieDataSet pieDataSet = new PieDataSet(yEntries,"Count of Processes");
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
//        colors.add(Color.RED);
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
//
//    }
//}