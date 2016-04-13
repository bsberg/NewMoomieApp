package com.example.brianberg.moomie2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bob on 4/9/2016.
 */
public class MovieAdapter extends ArrayAdapter<MovieObject> {

    public MovieAdapter(Context context, ArrayList<MovieObject> movies) {
        super(context, 0, movies);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup Parent) {
        MovieObject movieObject = getItem(position);
        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.movie_row_layout, Parent, false);
        }

        TextView movieRating = (TextView) convertView.findViewById(R.id.movie_rating);
        TextView movieTitle = (TextView) convertView.findViewById(R.id.movie_title);
        ImageView moviePoster = (ImageView) convertView.findViewById(R.id.movie_poster);

        switch (movieObject.moomieRating) {
            case 0:
                movieRating.setText("A");
                break;
            case 1:
                movieRating.setText("B");
                break;
            case 2:
                movieRating.setText("C");
                break;
            case 3:
                movieRating.setText("D");
                break;
            case 4:
                movieRating.setText("F");
                break;
        }

        //movieRating.setText("" + movieObject.moomieRating);
        movieTitle.setText(movieObject._title + " (" + movieObject._year + ") - " + movieObject._rating);

        moviePoster.setImageBitmap(movieObject.get_posterBitMap());
        return convertView;
    }
}
