package com.example.brianberg.moomie2;

/**
 * Created by Bob on 4/4/2016.
 */
public class MovieDataProvider {

    private int movie_poster_resource;
    private String movie_title;
    private String movie_rating;

    public MovieDataProvider(int movie_poster_resource, String movie_title, String movie_rating){
        this.movie_poster_resource = movie_poster_resource;
        this.movie_title = movie_title;
        this.movie_rating = movie_rating;
    }

    public int getMovie_poster_resource() {
        return movie_poster_resource;
    }

    public void setMovie_poster_resource(int movie_poster_resource) {
        this.movie_poster_resource = movie_poster_resource;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public String getMovie_rating() {
        return movie_rating;
    }

    public void setMovie_rating(String movie_rating) {
        this.movie_rating = movie_rating;
    }
}
