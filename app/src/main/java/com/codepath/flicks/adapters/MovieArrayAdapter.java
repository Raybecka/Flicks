package com.codepath.flicks.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.codepath.flicks.models.Movie;

import java.util.List;

public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter(Context context, List<Movie> movies){
        super (context, android.R.layout.simple_list_item_1, movies);

    }

}