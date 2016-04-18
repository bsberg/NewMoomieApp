package com.example.brianberg.moomie2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        // getActivity().setContentView(R.layout.fragment_movie);


        final DatabaseHandler db = new DatabaseHandler(getActivity());

        //CRUD Operations: Create, Update, Delete can go here:

        // Read all of the movies
        Log.d("Movie Fragment", "Reading all movies...");
        List<MovieObject> moovies = db.getAllMovieObjects();
        ArrayList<MovieObject> movies = new ArrayList<MovieObject>(moovies);


        // Log movies to see if movies correct
        for (MovieObject moo : movies) {
            String log = "Id: " + moo.getID() + ", Title: " + moo.getTitle() + ", Plot: " + moo.getPlot();
            Log.d("Movie Fragment", log);
            Log.d("Movie Fragment", "Poster: " + moo.getPosterURL());
        }

        // Delete movies if nececssary
//        for (MovieObject moo : movies) {
//            Log.d("Database","Deleting Movie");
//            db.deleteMovieObject(moo);
//        }

        // Create Adapter
        listView = (ListView) view.findViewById(R.id.movie_list_view_blah);
        adapter = new MovieAdapter(getContext(), movies);

        // Check for clicks
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MovieObject object = (MovieObject) parent.getItemAtPosition(position);
                String item = object.getTitle();

                switch (object.getMoomieRating()) {
                    case 0:
                        object.setMoomieRating(1);
                        break;
                    case 1:
                        object.setMoomieRating(2);
                        break;
                    case 2:
                        object.setMoomieRating(3);
                        break;
                    case 3:
                        object.setMoomieRating(4);
                        break;
                    case 4:
                        object.setMoomieRating(0);
                        break;
                }

                db.updateMovieObject(object);
                adapter.notifyDataSetChanged();
                view.setAlpha(1);
            }
        });

        // Set Adapter
        listView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return view;
    }
}
