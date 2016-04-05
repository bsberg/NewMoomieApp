package com.example.brianberg.moomie2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddMovieOMDB extends Fragment {


    public AddMovieOMDB() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //super.onCreateView(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //b1 = (Button)findViewByID(R.id.button);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_movie_omdb, container, false);
    }

}
