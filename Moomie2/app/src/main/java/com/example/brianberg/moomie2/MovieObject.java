package com.example.brianberg.moomie2;

/**
 * Created by Jerry Sommerfeld on 3/29/2016.
 */
public class MovieObject {
    String _id;
    String _title;
    String _plot;

    // Empty Constructor
    public MovieObject() {

    }

    // Constructor
    public MovieObject(String id, String title, String plot) {
        this._id = id;
        this._title = title;
        this._plot = plot;
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

    // Get movie plot
    public String getPlot() {
        return this._plot;
    }

    // Set the movie plot
    public void setPlot(String plot) {
        this._plot = plot;
    }
}
