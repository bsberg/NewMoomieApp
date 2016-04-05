package com.example.brianberg.moomie2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {


    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        DatabaseHandler db = new DatabaseHandler(getContext());

        //CRUD Operations
        Log.d("Insert: ", "Inserting...");
        db.addMovieObject(new MovieObject("1", "The Revenant", "Leo gets mauled by a bear"));
        db.addMovieObject(new MovieObject("2", "Star Wars", "Rebels blow up a space station"));
        db.addMovieObject(new MovieObject("3", "Animal House", "Toga, toga, toga!"));

        // Read all of the movies
        Log.d("Reading: ", "Reading all movies..");
        List<MovieObject> movies = db.getAllMovieObjects();

        for(MovieObject moo : movies) {
            String log = "Id: " + moo.getID() + ", Title: " + moo.getTitle() + ", Plot: " + moo.getPlot();
            Log.d("Movies: ", log);
        }

        // Read all of the movies
        Log.d("Deleting: ", "Deleting all movies..");
        List<MovieObject> moviesDel = db.getAllMovieObjects();

        for(MovieObject moo : moviesDel) {
            db.deleteMovieObject(moo);
        }

        // Read all of the movies
        Log.d("Reading: ", "Reading all movies that remain..");
        List<MovieObject> moviesRem = db.getAllMovieObjects();

        for(MovieObject moo : moviesRem) {
            String log = "Id: " + moo.getID() + ", Title: " + moo.getTitle() + ", Plot: " + moo.getPlot();
            Log.d("Movies: ", log);
        }


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }



}
