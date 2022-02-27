package com.example.navigationdrawerdemo;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.TextView;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.google.gson.Gson;
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
    private JsonObject recipeOfTheDay;
    private Context context;
    Response<JsonObject> recipeOfTheDay_response;
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
    APIHandler(Context context){
        this.context = context;
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
    public  boolean checkInternetConnection(){
        ConnectivityManager connMng = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMng.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return true;
        }
        return false;
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
                Constants.BEARER_TOKEN_GENERATED_FLAG = true;

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

    public JsonObject recipeOfTheDay(LoadingDialogHandler loadingDialogHandler){
        if(!checkInternetConnection()) {
            loadingDialogHandler.stopAlertDialog();
            return null;
        }
        Call<JsonObject> call = jsonPlaceHolderApi.getRecipeOfTheDay(Constants.BEARER_TOKEN);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(!response.isSuccessful()){
                    Log.d(Constants.TAG, "recipeOfTheDay -> onResponse: UNSUCCESSFUL RESPONSE");
//                    textView.setText("code : "+response.code());
                    return;
                }
                recipeOfTheDay = response.body();
               // Object imgurl = recipeOfTheDay.get("img_url");
//                Log.d(Constants.TAG, "onResponse: IMAGE URL "+imgurl);
               // recipeOfTheDay_response = response;
                Constants.RECIPE_OF_THE_DAY_IMAGE_DOWNLOADED = true;
                Log.d(Constants.TAG, "response.code: "+response.code());
                Log.d(Constants.TAG, "response.toString: "+response.toString());
                Log.d(Constants.TAG, "response.body: "+response.body());
                Log.d(Constants.TAG, "response.message: "+response.message());
                Log.d(Constants.TAG, "response.headers: "+response.headers());
                Log.d(Constants.TAG, "response.raw: "+response.raw());

                Gson gson = new Gson();
                RecipeDetails recipeDetails = gson.fromJson(recipeOfTheDay,RecipeDetails.class);

                Intent intent = new Intent("com.example.navigationdrawerdemo");
                intent.putExtra("RECIPEOFTHEDAY",recipeDetails);
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
//                pDialog.hide();
                loadingDialogHandler.stopAlertDialog();
//                pDialog.h
//                intent.putExtra()
//                Log.d(Constants.TAG, "onResponse: "+recipeDetails);

//                intent.putExtra("JSON_BODY",);
//                int newsnum = updateNewsNum();
//                intent.putExtra("NEWS_NUM",newsnum);
//            LocalBroadcastManager manager = LocalBroadcastManager.getInstance(get)
//            manager.sendBr
//                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
//                pDialog.hide();
                loadingDialogHandler.stopAlertDialog();
            }
        });
//        return recipeOfTheDay_response;
        return recipeOfTheDay;
    }

    public String getRecipeInfo(int recipeId, TextView textView_response){
        receipe_info = "";
        //String receipe_info_returnval;
//        Post post = new Post(231,"NeW Title","New Text");
        Call<JsonObject> call = jsonPlaceHolderApi.getRecipeInfo(recipeId,Constants.BEARER_TOKEN);
//        Call<Post> call = jsonPlaceHolderApi.createPost(post);

        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if(!response.isSuccessful()){
//                    textView.setText("code : "+response.code());
                    return;
                }
                JsonObject posrResponse = response.body();
                Log.d("jain", "response.code: "+response.code());
                Log.d("jain", "response.toString: "+response.toString());
                Log.d("jain", "response.body: "+response.body());
                Log.d("jain", "response.message: "+response.message());
                Log.d("jain", "response.headers: "+response.headers());
                Log.d("jain", "response.raw: "+response.raw());
                String content = "Code:  "+response.code()+"\n";
//                String receipe_info ="";

                //ITERATING OVER JSON OBJ
//                Iterator<String> keys = posrResponse.keySet().iterator();
//                while(keys.hasNext()) {
//                    String key = keys.next();
//                    JsonElement jsonElement = posrResponse.get(key);
//                    if(jsonElement!=null){
//                    Log.d("jain", key + " : " + jsonElement.getAsString());
//                    String keyval = key +" : "+jsonElement.getAsString()+"\n";
//                    receipe_info += keyval;
//                    }//ek value null a rhi thi isiliye faya
//
//                }

                for (String keyStr : posrResponse.keySet()) {
                    Object keyvalue = posrResponse.get(keyStr);

                    //Print key and value
                    Log.d("jain", keyStr + " : " + keyvalue);
                    String keyval = keyStr +" : "+keyvalue+"\n";
                    receipe_info += keyval;
                    //for nested objects iteration if required
                    //if (keyvalue instanceof JSONObject)
                    //    printJsonObject((JSONObject)keyvalue);
                }

//                assert posrResponse != null;

                // String accessToken = posrResponse.get("access_token").toString();
                //getAsString("access_token");
                // content+="ACCESS TOKEN :: "+accessToken;
//                content += "ID:"+posrResponse.getId()+"\n";
//                content+="User Id :"+posrResponse.getUserId()+"\n";
//                content+= "Title : "+posrResponse.getTitle()+"\n";
//                content+="Text : "+posrResponse.getText()+"\n \n ";

                textView_response.setText(receipe_info);
               // receipe_info_returnval=receipe_info;

//                Intent intent = new Intent(this,RecipeInfo.class);
//                intent.putExtra("RECIPE_INFO_BY_ID",receipe_info);
//                startActivity(intent);
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
//                textView.setText(t.getMessage());
                textView_response.setText("INVALID ID");
            }
        });

return receipe_info;
    }

    public String getRecipeBySubregion(String subregion, TextView textView_response){
        receipe_info = "";
        //String receipe_info_returnval;
//        Post post = new Post(231,"NeW Title","New Text");
        Call<RecipeDetails[]> call = jsonPlaceHolderApi.getRecipeBySubregion(subregion,Constants.BEARER_TOKEN);
//        Call<Post> call = jsonPlaceHolderApi.createPost(post);

        call.enqueue(new Callback<RecipeDetails[]>() {
            @Override
            public void onResponse(Call<RecipeDetails[]> call, Response<RecipeDetails[]> response) {
                if(!response.isSuccessful()){
                    textView_response.setText("code : "+response.code());
                    return;
                }
                RecipeDetails[] recipebysubregionResponse = response.body();
                //WE ARE GETTING THE RECIPES BY THE SUBREGION
                //IT RETURN THE ARRAY OF RECIPE DETAILS OBJECT
                Log.d(Constants.TAG, "response.code: posrResponse.length :::"+recipebysubregionResponse.length);
                for(RecipeDetails rec : recipebysubregionResponse){
                    receipe_info+=rec.getEnergykcal();
                    receipe_info+="\n";
                }
                Log.d(Constants.TAG, "onResponse: energukcal"+receipe_info);
//                Log.d("jain", "response.toString: "+response.toString());
//                Log.d("jain", "response.body: "+response.body());
//                Log.d("jain", "response.message: "+response.message());
//                Log.d("jain", "response.headers: "+response.headers());
//                Log.d("jain", "response.raw: "+response.raw());
//                String content = "Code:  "+response.code()+"\n";
//                String receipe_info ="";

                //ITERATING OVER JSON OBJ
//                Iterator<String> keys = posrResponse.keySet().iterator();
//                while(keys.hasNext()) {
//                    String key = keys.next();
//                    JsonElement jsonElement = posrResponse.get(key);
//                    if(jsonElement!=null){
//                    Log.d("jain", key + " : " + jsonElement.getAsString());
//                    String keyval = key +" : "+jsonElement.getAsString()+"\n";
//                    receipe_info += keyval;
//                    }//ek value null a rhi thi isiliye faya
//
//                }

//                for (String keyStr : posrResponse.keySet()) {
//                    Object keyvalue = posrResponse.get(keyStr);
//
//                    //Print key and value
//                    Log.d("jain", keyStr + " : " + keyvalue);
//                    String keyval = keyStr +" : "+keyvalue+"\n";
//                    receipe_info += keyval;
                    //for nested objects iteration if required
                    //if (keyvalue instanceof JSONObject)
                    //    printJsonObject((JSONObject)keyvalue);
//                }

//                assert posrResponse != null;

                // String accessToken = posrResponse.get("access_token").toString();
                //getAsString("access_token");
                // content+="ACCESS TOKEN :: "+accessToken;
//                content += "ID:"+posrResponse.getId()+"\n";
//                content+="User Id :"+posrResponse.getUserId()+"\n";
//                content+= "Title : "+posrResponse.getTitle()+"\n";
//                content+="Text : "+posrResponse.getText()+"\n \n ";

                textView_response.setText(receipe_info);
                // receipe_info_returnval=receipe_info;

//                Intent intent = new Intent(this,RecipeInfo.class);
//                intent.putExtra("RECIPE_INFO_BY_ID",receipe_info);
//                startActivity(intent);
            }

            @Override
            public void onFailure(Call<RecipeDetails[]> call, Throwable t) {
//                textView.setText(t.getMessage());
                textView_response.setText("INVALID ID");
            }
        });

        return receipe_info;
    }

    public String getRecipeByRegion(String region, TextView textView_response){
        Log.d(Constants.TAG, "getRecipeByRegion: ");
        receipe_info = "";
        //String receipe_info_returnval;
//        Post post = new Post(231,"NeW Title","New Text");
        Call<RecipeDetails[]> call = jsonPlaceHolderApi.getRecipeByRegion(region,Constants.BEARER_TOKEN);
//        Call<Post> call = jsonPlaceHolderApi.createPost(post);
        Log.d(Constants.TAG, "getRecipeByRegion: 2");
        call.enqueue(new Callback<RecipeDetails[]>() {
            @Override
            public void onResponse(Call<RecipeDetails[]> call, Response<RecipeDetails[]> response) {
                Log.d(Constants.TAG, "onResponse: "+response.code());
                if(!response.isSuccessful()){
                    textView_response.setText("code : "+response.code());
                    return;
                }
               // RecipeDetails[] recipebyregionResponse = response.body();
                Log.d(Constants.TAG, "response.code: posrResponse.length :::");
                //WE ARE GETTING THE RECIPES BY THE SUBREGION
                //IT RETURN THE ARRAY OF RECIPE DETAILS OBJECT
//                for(RecipeDetails rec : recipebysubregionResponse){
//                    receipe_info+=rec.get_id();
//                    receipe_info+="\n";
//                }
//                Log.d("jain", "response.toString: "+response.toString());
//                Log.d("jain", "response.body: "+response.body());
//                Log.d("jain", "response.message: "+response.message());
//                Log.d("jain", "response.headers: "+response.headers());
//                Log.d("jain", "response.raw: "+response.raw());
//                String content = "Code:  "+response.code()+"\n";
//                String receipe_info ="";

                //ITERATING OVER JSON OBJ
//                Iterator<String> keys = posrResponse.keySet().iterator();
//                while(keys.hasNext()) {
//                    String key = keys.next();
//                    JsonElement jsonElement = posrResponse.get(key);
//                    if(jsonElement!=null){
//                    Log.d("jain", key + " : " + jsonElement.getAsString());
//                    String keyval = key +" : "+jsonElement.getAsString()+"\n";
//                    receipe_info += keyval;
//                    }//ek value null a rhi thi isiliye faya
//
//                }

//                for (String keyStr : posrResponse.keySet()) {
//                    Object keyvalue = posrResponse.get(keyStr);
//
//                    //Print key and value
//                    Log.d("jain", keyStr + " : " + keyvalue);
//                    String keyval = keyStr +" : "+keyvalue+"\n";
//                    receipe_info += keyval;
                //for nested objects iteration if required
                //if (keyvalue instanceof JSONObject)
                //    printJsonObject((JSONObject)keyvalue);
//                }

//                assert posrResponse != null;

                // String accessToken = posrResponse.get("access_token").toString();
                //getAsString("access_token");
                // content+="ACCESS TOKEN :: "+accessToken;
//                content += "ID:"+posrResponse.getId()+"\n";
//                content+="User Id :"+posrResponse.getUserId()+"\n";
//                content+= "Title : "+posrResponse.getTitle()+"\n";
//                content+="Text : "+posrResponse.getText()+"\n \n ";

                textView_response.setText(receipe_info);
                // receipe_info_returnval=receipe_info;

//                Intent intent = new Intent(this,RecipeInfo.class);
//                intent.putExtra("RECIPE_INFO_BY_ID",receipe_info);
//                startActivity(intent);
            }

            @Override
            public void onFailure(Call<RecipeDetails[]> call, Throwable t) {
                Log.d(Constants.TAG, "onFailure: "+call.toString()+t);
//                textView.setText(t.getMessage());
                textView_response.setText("INVALID ID");
            }
        });

        return receipe_info;
    }

}
