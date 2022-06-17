package com.example.navigationdrawerdemo.fragments;

import android.app.ProgressDialog;
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


public class CategoriesStat extends Fragment {
    private WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_categories_stat, container, false);
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
                webView.loadUrl("https://recipedb-androidapplication.herokuapp.com/recipedb_categories_map");// CATEGORIES MAP
        //        webView.loadUrl("https://recipedb-androidapplication.herokuapp.com/recipedb_ingredientsmap");// INGREDIENTS CHART
//        webView.loadUrl("https://recipedb-androidapplication.herokuapp.com/recipedb_nutrition_map");// NUTRITION CHART
        //        webView.loadUrl("https://recipedb-androidapplication.herokuapp.com/recipedb_processes_map");// PROCESSES CHART
        //        webView.loadUrl("https://recipedb-androidapplication.herokuapp.com/recipedb_utensils_map");//UTENSILS CHART


//        webView.addJavascriptInterface(new WebAppInterface(getBaseContext()),"ANDROID");
//        webView.requestFocus();

        return v;
    }
}