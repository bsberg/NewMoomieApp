package com.example.brianberg.moomie2;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Jerry Sommerfeld on 3/29/2016.
 * A java class dedicated to the Moomie Movie database and rating system
 */
public class MovieObject {
    String _id;
    String _title;
    String _year;
    String _rating;
    String _director;
    String _actors;
    String _plot;
    String _posterURL;

    Bitmap _posterBitMap;

    private int moomieRating;

    // Empty Constructor
    public MovieObject() {

    }

    // Constructor
    public MovieObject(String id, String title, String year, String rating, String director, String actors, String plot, String posterURL) {
        this._id = id;
        this._title = title;
        this._year = year;
        this._rating = rating;
        this._director = director;
        this._actors = actors;
        this._plot = plot;
        this._posterURL = posterURL;

        //Initialize rating to 0
        this.moomieRating = 0;

        //Initialize posterBitmap
        setMoviePoster(_posterURL);
    }

    // Get the movieID
    public String getID() {
        return this._id;
    }

    // Setting movieID
    public void setID(String id) {
        this._id = id;
    }

    // Get the movie title
    public String getTitle() {
        return this._title;
    }

    // Setting movie title
    public void setTitle(String title) {
        this._title = title;
    }

    // Get the movie year
    public String getYear() {
        return this._year;
    }

    // Set the movie year
    public void setYear(String year) {
        this._year = year;
    }

    // Get the movie MPAA rating
    public String getRating() {
        return this._rating;
    }

    // Set the movie MPAA rating
    public void setRating(String rating) {
        this._rating = rating;
    }

    // Get the movie Director
    public String getDirector() {
        return this._director;
    }

    // Set the movie Director
    public void setDirector(String director) {
        this._director = director;
    }

    // Get the movie Actors
    public String getActors() {
        return this._actors;
    }

    // Set the movie Actors
    public void setActors(String actors) {
        this._actors = actors;
    }

    // Get movie plot
    public String getPlot() {
        return this._plot;
    }

    // Set the movie plot
    public void setPlot(String plot) {
        this._plot = plot;
    }

    // Get the movie poster URL
    public String getPosterURL() {
        return this._posterURL;
    }

    // Set the movie poster URL
    public void setPosterURL(String url) {
        this._posterURL = url;
        setMoviePoster(_posterURL);
    }

    // get the Moomie rating
    public int getMoomieRating() {
        return this.moomieRating;
    }

    // Set the Moomie Rating
    public void setMoomieRating(int rating) {
        this.moomieRating = rating;
    }

    public Bitmap get_posterBitMap() {
        return _posterBitMap;
    }

    public void set_posterBitMap(Bitmap _posterBitMap) {
        this._posterBitMap = _posterBitMap;
    }

    /* Mostly from http://www.tutorialspoint.com/android/android_network_connection.htm
     * Takes a URL and returns a bitmap
     */
    void setMoviePoster(final String url){
        new Thread() {
            public void run() {
                InputStream in = null;

                //msg = Message.obtain();
                //msg.what = 1;

                try {
                    Log.d("MovieObject: ", url);
                    in = openHttpConnection(url);
                    _posterBitMap = BitmapFactory.decodeStream(in);

                    // ImageView ImageTooSwitch = (ImageView) view.findViewById(R.id.ImageToSwitch);
                    //Bundle b = new Bundle();
                    //b.putParcelable("bitmap", bitmap);
                    //msg.setData(b);
                    in.close();
                }
                catch (IOException e1) {
                    e1.printStackTrace();
                }
                //messageHandler.sendMessage(msg);
            }
        }.start();

        try{
            Thread.sleep(300);
        }catch (InterruptedException e){
            Log.d("ToolsFragment","InterruptedException");
        }

        if(_posterBitMap == null) Log.d("ToolsFragment:", "Bitmap == null");
        Log.d("ToolsFragment", "Bitmap worked");
    }


    // This for getting pictures, its from http://www.tutorialspoint.com/android/android_network_connection.htm
    private InputStream openHttpConnection(String urlString){
        InputStream in = null;
        int resCode = -1;

        try {
            URL url = new URL(urlString);
            URLConnection urlConn = url.openConnection();
            if(!(urlConn instanceof HttpURLConnection)) {
                throw new IOException("Url is not an Http URL");
            }
            HttpURLConnection httpConn = (HttpURLConnection) urlConn;
            httpConn.setAllowUserInteraction(false);
            httpConn.setInstanceFollowRedirects(true);
            resCode = httpConn.getResponseCode();

            if (resCode == HttpURLConnection.HTTP_OK) {
                in = httpConn.getInputStream();
            }
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return in;
    }
}
