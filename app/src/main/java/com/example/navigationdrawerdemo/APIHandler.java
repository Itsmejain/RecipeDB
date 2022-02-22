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

    public String getRecipeInfo(int recipeId, TextView textView_response){
        receipe_info = "";
        //String receipe_info_returnval;
//        Post post = new Post(231,"NeW Title","New Text");
        Call<JsonObject> call = jsonPlaceHolderApi.getRecipeInfo(recipeId,bearerToken);
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

}
