package com.example.moviemanager.adapters;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviemanager.Movies.Movie;
import com.example.moviemanager.R;
import com.example.moviemanager.activities.MovieDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder> {

    Context context;
    List<Movie> movies;

    public MovieRecyclerViewAdapter(Context context, List<Movie> movies){
        this.movies = movies;
        this.context = context;
    }

    private Context getContext(){
        return context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Movie movie = movies.get(i);

        viewHolder.tvMovieTitle.setText(movie.getTitle());
        viewHolder.tvMovieContent.setText(movie.getDescription());

        Picasso.with(getContext()).load(movie.getPosterPath()).into(viewHolder.ivMovieImage);


    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.ivMovieImage)
        ImageView ivMovieImage;
        @BindView(R.id.tvMovieTitle)
        TextView tvMovieTitle;
        @BindView(R.id.tvMovieContent)
        TextView tvMovieContent;
        @BindView(R.id.cvMovies)
        CardView cvMovies;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Movie movie = movies.get(getAdapterPosition());
            Intent intent = new Intent(getContext(), MovieDetailActivity.class);

            intent.putExtra("MOVIE", movie);
            getContext().startActivity(intent);




        }

//        @Override
//        public void onClick(View v) {
//            Movie movie = movies.get(getAdapterPosition());
//            Intent intent = new Intent(getContext(), MovieDetailActivity.class)
//
//        }
    }
}
