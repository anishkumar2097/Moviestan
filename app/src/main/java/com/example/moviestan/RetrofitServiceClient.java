package com.example.moviestan;

import android.util.Log;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServiceClient {

    private static final String TAG = "RetrofitServiceClient";
    private static String BASE_URL = "https://api.themoviedb.org/3/";
    private static Retrofit retrofit = null;

    public static RetrofitServiceAPI getClient() {

        // change your base URL
        if (retrofit == null) {
            try {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                      .addConverterFactory(GsonConverterFactory.create())
                        .build();
            } catch (Exception ex) {
                Log.e(TAG, "getClient:");
            }
        }
            //Creating object for our interface
            RetrofitServiceAPI api = retrofit.create(RetrofitServiceAPI.class);
            return api; // return the APIInterface object



    }
}
