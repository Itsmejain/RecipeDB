package com.example.navigationdrawerdemo;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIHandler {
    private String bearerToken;
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private  HttpLoggingInterceptor httpLoggingInterceptor;
    private  Retrofit retrofit;
    private  OkHttpClient okHttpClient;
    private String receipe_info;
    APIHandler(){
         httpLoggingInterceptor = new HttpLoggingInterceptor();
         httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
         okHttpClient = new OkHttpClient.Builder().
                addInterceptor(httpLoggingInterceptor)
                .build();
         retrofit = new Retrofit.Builder()
                .baseUrl(Constants.RETROFIT_BASE_URL) // Slash at the end is compulsory
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
    }

    public String getBearerToken() {
        return bearerToken;
    }

    public String getReceipe_info() {
        return receipe_info;
    }

    public void bearerTokenGenerator(){
        Call<JsonObject> call = jsonPlaceHolderApi.
                bearerTokenGenerator(
                        Constants.BEARER_TOKEN_GRANT_TYPE,
                        Constants.BEARER_TOKEN_CLIENT_ID,
                        Constants.BEARER_TOKEN_USERNAME,
                        Constants.BEARER_TOKEN_PASSWORD,
                        Constants.BEARER_TOKEN_SCOPE);
//        Call<Post> call = jsonPlaceHolderApi.createPost(post); // we may create object for our RECIPE and get information from there
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(!response.isSuccessful()){
                    String errorCode = "RESPONE_CODE : "+response.code();
                    Log.d(Constants.TAG, "APIHANDLER.onRESPONSE: "+errorCode);
                    bearerToken = "ERROR";
                    return;
                }
                JsonObject postResponse = response.body();
                JsonElement accessTokenJsonElement = postResponse.get("access_token");
                String accessToken = accessTokenJsonElement.getAsString();
                bearerToken = "Bearer "+accessToken;
                Constants.BEARER_TOKEN = bearerToken;
                Log.d(Constants.TAG, "onResponse: bearerToken  "+bearerToken);
                Log.d(Constants.TAG, "Constants.BEARER_TOKEN :: "+Constants.BEARER_TOKEN);
                return ;

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
               // textView.setText(t.getMessage());
                bearerToken = "ERROR";
                Log.d(Constants.TAG, "APIHANDLER.onFailure: "+t.getMessage());
            }
        });

    }



}
