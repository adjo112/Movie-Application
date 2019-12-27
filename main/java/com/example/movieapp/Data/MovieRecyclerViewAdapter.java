package com.example.movieapp.Data;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.Activities.MovieDetailActivity;
import com.example.movieapp.Model.Movie;
import com.example.movieapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<Movie> moviesList;
    public MovieRecyclerViewAdapter(Context context, List<Movie> movies) {
         this.context = context;
         moviesList = movies;
    }

    @NonNull
    @Override
    public MovieRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_row, parent, false);



        return new ViewHolder(view, context);

    }

    @Override
    public void onBindViewHolder(@NonNull MovieRecyclerViewAdapter.ViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
        String posterLink =  movie.getPoster();

        holder.title.setText(movie.getTitle());
        holder.type.setText(movie.getMovieType());

        Picasso.with(context)
                .load(posterLink)
                .placeholder(android.R.drawable.ic_btn_speak_now)
                .into(holder.poster);

        holder.year.setText(movie.getYear());

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView poster;
        TextView year;
        TextView type;

        public ViewHolder(@NonNull View itemView,final Context ctx) {
            super(itemView);
            context = ctx;

            title =  itemView.findViewById(R.id.movietitleID);
            poster =  itemView.findViewById(R.id.movieimageID);
            year =  itemView.findViewById(R.id.moviereleaseID);
            type = itemView.findViewById(R.id.moviecatID);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Movie movie = moviesList.get(getAdapterPosition());

                    Intent intent = new Intent(context, MovieDetailActivity.class);

                    intent.putExtra("movie", movie);
                    ctx.startActivity(intent);

                }
            });
        }

    }
}
