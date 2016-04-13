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
    List list = new ArrayList();
    Bitmap bitmap = null;

    public MovieAdapter(Context context, ArrayList<MovieObject> movies) {
        super(context, 0, movies);
    }

    static class DataHandler
    {
        ImageView Poster;
        TextView title;
        TextView rating;
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

        movieRating.setText(movieObject._rating);
        movieTitle.setText(movieObject._title);

        moviePoster.setImageBitmap(movieObject.get_posterBitMap());
        return convertView;
    }
}
