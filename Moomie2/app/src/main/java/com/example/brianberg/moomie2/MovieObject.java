package com.example.brianberg.moomie2;


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

    int moomieRating;

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
    }

    // get the Moomie rating
    public int getMoomieRating() {
        return this.moomieRating;
    }

    // Set the Moomie Rating
    public void setMoomieRating(int rating) {
        this.moomieRating = rating;
    }

}
