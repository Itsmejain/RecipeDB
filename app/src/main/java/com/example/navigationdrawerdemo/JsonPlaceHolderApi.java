package com.example.navigationdrawerdemo;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {
    //TO GENERATE BEARER TOKEN
    @FormUrlEncoded
    @POST("api/auth/realms/bootadmin/protocol/openid-connect/token")
    Call<JsonObject> bearerTokenGenerator(
            @Field("grant_type") String grant_type,
            @Field("client_id") String client_id,
            @Field("username") String username,
            @Field("password") String password,
            @Field("scope") String scope

    );
//RECIPE SEARCH BY ID
//@Headers({"Authorization:Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI1N1R4M2FWRzR0N0Q5YW00TDlod1VHR2tPVVlvOUpwVFd1VTNmTWxrY1lBIn0.eyJleHAiOjE2NDM5MDkyMTcsImlhdCI6MTY0MzkwODkxNywianRpIjoiOWYwYTYyZjMtNDdmNC00ODQzLWI2OWEtN2RmZWQ3NGZmNGM2IiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2F1dGgvcmVhbG1zL2Jvb3RhZG1pbiIsImF1ZCI6WyJhcHAtYWRtaW4iLCJhcHAtdG9kbyIsImFjY291bnQiXSwic3ViIjoiOGU2OGY4YzctNzZjYy00ODJlLWFlNmQtNDliNDA3MjBjZjBjIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiYXBwLWltcyIsInNlc3Npb25fc3RhdGUiOiIxYzhiM2QwNi0zNWFkLTQ3MmUtYmM5ZC03ZmYwMzMwNDI3Y2QiLCJhY3IiOiIxIiwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhcHAtYWRtaW4iOnsicm9sZXMiOlsiYWRtaW4iXX0sImFwcC10b2RvIjp7InJvbGVzIjpbImFkbWluIiwidXNlciJdfSwiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJvcGVuaWQgZW1haWwgcHJvZmlsZSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6Ik1hbmFzIEt1bGthcm5pIiwicHJlZmVycmVkX3VzZXJuYW1lIjoibWFuYXMiLCJnaXZlbl9uYW1lIjoiTWFuYXMiLCJmYW1pbHlfbmFtZSI6Ikt1bGthcm5pIn0.VvEY37etKHTqUtE4l5UZuzwCrlsBii6ap4eyb8SItLAML_DtthvCPUGzOl6qXLXeqaw3pm1KoPXl0bI8j5UOXeqvG07tPn9HpOP0X1QxqlCElIDal98_44yiV0FCCvS-3w2zE7OY0Z_-4u3G_B9Lha9_7pUCdLdYlc43xQVseEOjG70IXjmXm9ZY0bz1IYp2F8dcma8uJQQdW480BfSu8uS4g0z0KOvjUuUnkFggZ01KkECoJvONHIaI1xn95B-3aKRPG-A5GCyK5r6bA_35PfSkuw6Y1wqL7y5jGqFRvSxbBqwBygwhNLndZOUm-pHiWE6Ijb193Vz1ndt-YmuquA"})
//    @Headers({"Authorization"})
    //https://cosylab.iiitd.edu.in/api/recipeDB/search_subregion/Bangladeshi
    @GET("api/recipeDB/recipeInfo/{id}")
    Call<JsonObject> getRecipeInfo(@Path("id") int recipeId,@Header("Authorization") String token);

    //RECIPE OF THE DAY
    @GET("api/recipeDB/recipeoftheday")
    Call<JsonObject> getRecipeOfTheDay(@Header("Authorization") String token);



//    @GET("posts")
//    Call<List<Post>> getPost();
//
//    @GET("posts")
//    Call<JsonArray> getPostTest(@Query("userId") Integer userId);
//
//    @GET("posts")
//    Call<List<Post>> getPosts(@Query("userId") Integer[] userId,//Integer can take Null
//
//                              @Query("_sort") String sort,
//                              @Query("_order") String order);
//
//    @GET("posts/2/comments")
//    Call<List<Comment>> getComments();

//    @GET("posts/{id}/comments")
//    Call<List<Comment>> getComments(@Path("id") int postId);
//
//    @GET("posts")//yaha par sub url ki jagah get me puri URL bhi daal sake wo base url ko replace kr degi
//    Call<List<Post>> getPostsdynamic(
//            @QueryMap Map<String,String> parameters);
//
//    @GET
//    Call<List<Comment>> getComments_URL(@Url String url);
//
//    @POST("posts")
//    Call<Post> createPost(@Body Post post);

   // @Headers({"Static-Header:123456","Static-header2:456"})
//    @FormUrlEncoded
//    @POST("posts")
//    Call<JsonObject> postRequest(
//            @Field("userId") int userId,
//            @Field("title") String title,
//            @Field("body") String text
//    );



//    @Headers({"Authorization:Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI1N1R4M2FWRzR0N0Q5YW00TDlod1VHR2tPVVlvOUpwVFd1VTNmTWxrY1lBIn0.eyJleHAiOjE2NDM5MDkyMTcsImlhdCI6MTY0MzkwODkxNywianRpIjoiOWYwYTYyZjMtNDdmNC00ODQzLWI2OWEtN2RmZWQ3NGZmNGM2IiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2F1dGgvcmVhbG1zL2Jvb3RhZG1pbiIsImF1ZCI6WyJhcHAtYWRtaW4iLCJhcHAtdG9kbyIsImFjY291bnQiXSwic3ViIjoiOGU2OGY4YzctNzZjYy00ODJlLWFlNmQtNDliNDA3MjBjZjBjIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiYXBwLWltcyIsInNlc3Npb25fc3RhdGUiOiIxYzhiM2QwNi0zNWFkLTQ3MmUtYmM5ZC03ZmYwMzMwNDI3Y2QiLCJhY3IiOiIxIiwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhcHAtYWRtaW4iOnsicm9sZXMiOlsiYWRtaW4iXX0sImFwcC10b2RvIjp7InJvbGVzIjpbImFkbWluIiwidXNlciJdfSwiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJvcGVuaWQgZW1haWwgcHJvZmlsZSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6Ik1hbmFzIEt1bGthcm5pIiwicHJlZmVycmVkX3VzZXJuYW1lIjoibWFuYXMiLCJnaXZlbl9uYW1lIjoiTWFuYXMiLCJmYW1pbHlfbmFtZSI6Ikt1bGthcm5pIn0.VvEY37etKHTqUtE4l5UZuzwCrlsBii6ap4eyb8SItLAML_DtthvCPUGzOl6qXLXeqaw3pm1KoPXl0bI8j5UOXeqvG07tPn9HpOP0X1QxqlCElIDal98_44yiV0FCCvS-3w2zE7OY0Z_-4u3G_B9Lha9_7pUCdLdYlc43xQVseEOjG70IXjmXm9ZY0bz1IYp2F8dcma8uJQQdW480BfSu8uS4g0z0KOvjUuUnkFggZ01KkECoJvONHIaI1xn95B-3aKRPG-A5GCyK5r6bA_35PfSkuw6Y1wqL7y5jGqFRvSxbBqwBygwhNLndZOUm-pHiWE6Ijb193Vz1ndt-YmuquA"})
//    @Headers({"Authorization"})
//    //https://cosylab.iiitd.edu.in/api/recipeDB/search_subregion/Bangladeshi
//    @GET("api/recipeDB/recipeInfo/{id}")
//    Call<JsonObject> getRecipeInfo(@Path("id") int recipeId,@Header("Authorization") String token);
//    accessToken
//    @GET("posts/{id}/comments")
//    Call<List<Comment>> getComments(@Path("id") int postId);


//    @Headers({"Static-Header:123456","Static-header2:456"})
//    @FormUrlEncoded
//    @POST("posts")
//    Call<Post> createPost_urlencoded(
//            @Field("userId") int userId,
//            @Field("title") String title,
//            @Field("body") String text
//    );
//
//    @Headers({"Static-Header:123456","Static-header2:456"})
//    @FormUrlEncoded
//    @POST("posts")
//    Call<Post> createPost_urlencoded_test(
//            @Field("userId") int userId,
//            @Field("title") String title,
//            @Field("body") String text
//    );

}
