package com.example.moviestan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class RecyclerMovieAdapter extends RecyclerView.Adapter<RecyclerMovieAdapter.ViewHolder> {
    private   List<Movie> mMovie =new ArrayList<Movie>();
    private Context context;
   private static String IMAGE_BASE_URL="https://image.tmdb.org/t/p/w500";

    public RecyclerMovieAdapter(List<Movie> movies, Context context){
        super();
        mMovie=movies;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
           Movie currentMovie=mMovie.get(position);
           holder.mRatingTextView.setText("Rating : "+currentMovie.getVoteAverage() + "");
        holder.mReleaseDateTextView.setText(currentMovie.getReleaseDate());
        holder.mIconTextView.setImageResource(R.drawable.ic_baseline_share_icon);




        holder.mTitleTextView.setText(currentMovie.getOriginalTitle());
        holder.mOverTextView.setText(currentMovie.getOverview());


        Glide.with(context).load(IMAGE_BASE_URL+currentMovie.getPosterPath()).into(holder.mMovieImageView);
    }

    @Override
    public int getItemCount() {
        return  mMovie.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mMovieImageView;
        CardView mCardView;
        TextView  mTitleTextView;
        TextView mRatingTextView;
        TextView mOverTextView;
        TextView mReleaseDateTextView;
        ImageView mIconTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mMovieImageView=(ImageView)itemView.findViewById(R.id.thumbnail_image_card);
            this.mCardView=(CardView)itemView.findViewById(R.id.card_view);
            this.mOverTextView=(TextView)itemView.findViewById(R.id.trail_text_card);
            this.mTitleTextView=(TextView)itemView.findViewById(R.id.title_card);
            this.mIconTextView=(ImageView)itemView.findViewById(R.id.share_image_card);
            this.mRatingTextView = (TextView)itemView.findViewById(R.id.rating_card);
            this.mReleaseDateTextView=(TextView)itemView.findViewById((R.id.date_card));

        }
    }
}
