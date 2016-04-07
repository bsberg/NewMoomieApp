package com.example.brianberg.moomie2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Bob on 4/1/2016.
 */
class MovieAdapter extends ArrayAdapter<String> {

    MovieAdapter(Context context, String[] movies){
        super(context, R.layout.friends_row, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater movieInflater = LayoutInflater.from(getContext());
        View movieView = movieInflater.inflate(R.layout.movie_row, parent, false);

        String singleFoodItem = getItem(position);
        TextView movieName = (TextView) movieView.findViewById(R.id.movieName);
        ImageView movieImage = (ImageView) movieView.findViewById(R.id.CowImage);

        movieName.setText(singleFoodItem);
        movieImage.setImageResource(R.drawable.cow);
        return movieView;
    }
}
