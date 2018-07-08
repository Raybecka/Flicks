package com.codepath.flicks.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.flicks.R;
import com.codepath.flicks.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter(Context context, List<Movie> movies){
        super (context, android.R.layout.simple_list_item_1, movies);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        // return super.getView(position, convertView, parent);
        //get the data item for position
        Movie movie = getItem(position);
        //check the existing view being reused
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
           convertView = inflater.inflate(R.layout.item_movie, parent, false);

        }

        // ind the image view
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);
        //clear out image from convertView
        ivImage.setImageResource(0);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverView = (TextView) convertView.findViewById(R.id.tvOverview);

        //populate data
        tvTitle.setText(movie.getOriginalTitle());
        tvOverView.setText(movie.getOverview());

        //return the view

        Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage);
        return convertView;


    }

}