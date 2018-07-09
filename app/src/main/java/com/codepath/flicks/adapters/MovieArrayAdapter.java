package com.codepath.flicks.adapters;

import android.content.Context;
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
    private static class ViewHolder{
        TextView tvTitle;
        TextView tvOverView;
        ImageView ivImage;

    }

    public MovieArrayAdapter(Context context, List<Movie> movies){
        super (context, android.R.layout.simple_list_item_1, movies);

    }

    @Override
    public View getView(int position, @Nullable View convertView, ViewGroup parent) {
        

        // return super.getView(position, convertView, parent);
        //get the data item for position
        Movie movie = getItem(position);
        //check the existing view being reused
        ViewHolder viewHolder;
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tvOverView= (TextView) convertView.findViewById(R.id.tvOverview);
            viewHolder.ivImage= (ImageView) convertView.findViewById(R.id.ivMovieImage);

            convertView.setTag(viewHolder);


        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //clear out image from convertView
        //viewHolder.ivImage.setImageResource(0);

               //populate data
       viewHolder.tvTitle.setText(movie.getOriginalTitle());
       viewHolder.tvOverView.setText(movie.getOverview());

        //return the view

       Picasso.with(getContext()).load(movie.getPosterPath()).into(viewHolder.ivImage);

       return convertView;



    }

}