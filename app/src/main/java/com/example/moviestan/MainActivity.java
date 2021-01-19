package com.example.moviestan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
      List<Movie> movies;
    String TAG=getClass().getSimpleName();
     private  static String API_KEY="24004952b9dc149d04d33479742bdff5";
     private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          displayMovie();
       //   displayMovieInRecyclerView(movies);
    }

    private void displayMovie()
    {
        RetrofitServiceClient.getClient().getMovieList(API_KEY).enqueue(new Callback<JSONdata>() {
            @Override
            public void onResponse(Call<JSONdata> call, Response<JSONdata> response) {

                  JSONdata data=response.body();

                movies=data.getResults();
               Log.d(TAG,"list is" +response.message());
             displayMovieInRecyclerView(movies);
            }

            @Override
            public void onFailure(Call<JSONdata> call, Throwable t) {
                  Log.d(TAG,t.getStackTrace().toString());
            }
        });
    }
    private void displayMovieInRecyclerView(List<Movie> movies){
        mRecyclerView=findViewById(R.id.recycler_view);
       RecyclerMovieAdapter adapter = new RecyclerMovieAdapter(movies,this);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);
    }
}