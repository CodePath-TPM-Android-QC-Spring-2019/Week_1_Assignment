package com.example.logan.movie1.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.logan.movie1.R;
import com.example.logan.movie1.models.Movie;

import org.parceler.Parcels;

import java.util.List;
import java.util.Map;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private Context context;
    private List<Movie> movies;
    public static final String MVBUNDLE = "MVBUNDLE";
    private Map<Integer, Movie> movieMap;

    /*Implement abstract methods from RecyclerView.Adapter*/
    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        Log.d("viewholder", "creating new view...");
        View view = LayoutInflater.from(context).inflate(R.layout.item_mov, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d("viewholder", "binding view at position " + position);
        Movie movie = movies.get(position);
        //Bind the movie data into the ViewHolder
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return movies.size(); // return the number of movie items that you wish the recycler view displays
    }

    //Create a constructor that takes in a context and list of movies
    public MoviesAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle, tvOverView;
        private ImageView ivPoster;
        private View container;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvOverView = itemView.findViewById(R.id.tvOverView);
            ivPoster = itemView.findViewById(R.id.ivPoster);
            container = itemView.findViewById(R.id.container);
        }

        public void bind(Movie movie) {
            tvTitle.setText(movie.getTitle());
            tvOverView.setText(movie.getOverView());

            Glide.with(context).
                    load(movie.getPosterPath())
                    .into(ivPoster);
            Log.d("Logan", movie.getPosterPath());
//            container.setOnClickListener(v -> {
//
//            });
        }
    }

}
