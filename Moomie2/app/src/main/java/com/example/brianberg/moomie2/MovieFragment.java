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
 * Used to display a list of movies in the Moomie database to read.
 */
public class MovieFragment extends Fragment {

    public MovieFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        DatabaseHandler db = new DatabaseHandler(getContext());

        //CRUD Operations: Create, Update, Delete can go here:

        // Read all of the movies
        Log.d("Movie Fragment", "Reading all movies...");
        List<MovieObject> movies = db.getAllMovieObjects();

        for(MovieObject moo : movies) {
            String log = "Id: " + moo.getID() + ", Title: " + moo.getTitle() + ", Plot: " + moo.getPlot();
            Log.d("Movie Fragment", log);
            Log.d("Movie Fragment", "Poster: " + moo.getPosterURL());
        }

//        // Delete all of the movies if needed
//        Log.d("Deleting: ", "Deleting all movies..");
//        List<MovieObject> moviesDel = db.getAllMovieObjects();
//        for(MovieObject moo : moviesDel) {
//            db.deleteMovieObject(moo);
//        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }



}
