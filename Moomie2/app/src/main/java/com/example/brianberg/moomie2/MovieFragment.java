package com.example.brianberg.moomie2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Used to display a list of movies in the Moomie database to read.
 */
public class MovieFragment extends Fragment {

    ListView listView;
    MovieAdapter adapter;

    public MovieFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setContentView(R.layout.fragment_movie);


        DatabaseHandler db = new DatabaseHandler(getActivity());

        //CRUD Operations: Create, Update, Delete can go here:

        // Read all of the movies
        Log.d("Movie Fragment", "Reading all movies...");
        List<MovieObject> moovies = db.getAllMovieObjects();
        ArrayList<MovieObject> movies = new ArrayList<MovieObject>(moovies);



        for (MovieObject moo : movies) {
            String log = "Id: " + moo.getID() + ", Title: " + moo.getTitle() + ", Plot: " + moo.getPlot();
            Log.d("Movie Fragment", log);
            Log.d("Movie Fragment", "Poster: " + moo.getPosterURL());
        }

        // Create Adapter
        listView = (ListView) getActivity().findViewById(R.id.movie_list_view_blah);
        adapter = new MovieAdapter(getContext(), movies);

        // Set Adapter
        listView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }
}
