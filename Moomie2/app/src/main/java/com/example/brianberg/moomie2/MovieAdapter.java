package com.example.brianberg.moomie2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bob on 4/9/2016.
 */
public class MovieAdapter extends ArrayAdapter<MovieObject> {
    List list = new ArrayList();

    public MovieAdapter(Context context, ArrayList<MovieObject> movies) {
        super(context, 0, movies);
    }

    static class DataHandler
    {
        ImageView Poster;
        TextView title;
        TextView rating;
    }

    /*@Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    }*/

    /*@Override
    public int getCount() {
        return this.list.size();
    }*/

    /*@Override
    public Object getItem(int position) {
        return this.list.get(position);
    }*/

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
        moviePoster.setImageBitmap(getMoviePosterImageFromUrl(movieObject.getPosterURL()));
        return convertView;
        /*View row;
        DataHandler handler;
        row = convertView;
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.movie_row_layout, Parent, false);
            handler = new DataHandler();
            handler.Poster = (ImageView) row.findViewById(R.id.movie_poster);
            handler.title = (TextView) row.findViewById(R.id.movie_title);
            handler.rating = (TextView) row.findViewById(R.id.movie_rating);

            row.setTag(handler);
        }
        else
        {
            handler = (DataHandler) row.getTag();
        }


        MovieObject dataProvider;
        dataProvider = (MovieObject) this.getItem(position);
        handler.Poster.setImageDrawable(getMoviePosterImageFromUrl(dataProvider.getPosterURL()));
        handler.rating.setText(dataProvider.getMoomieRating());
        handler.title.setText(dataProvider.getTitle());
        //LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //row = inflater.inflate(R.layout.movie_row_layout, Parent, false);
        return row;*/
    }

    Bitmap getMoviePosterImageFromUrl(String urlString){
        try {
            URL url = new URL(urlString);
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            return bmp;
        }
        catch(Exception e){
            return null;
        }
    }
}
