package com.example.moviestan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitServiceAPI {
    //https://api.themoviedb.org/3/movie/popular?api_key=24004952b9dc149d04d33479742bdff5


    @GET("movie/popular")
    Call<JSONdata>getMovieList(@Query("api_key") String apiKey);
   // Call<List<Movie>> getMovieList(@Query("api_key") String apiKey);
}
