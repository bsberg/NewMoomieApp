package com.example.brianberg.moomie2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    String[] movies = {"Rambo", "Rambo 2", "Rambo 3", "Rambo 4", "Hopefully Rambo 5", "Hopefully Rambo 6", "Maybe Rambo 7", "Definitely Rambo 8", "Terminator", "Terminator 2"};
    String[] ratings = {"10/10", "10/10", "10/10", "10/10", "10/10", "10/10", "10/10", "10/10", "10/10", "10/10"};
    int[] movieResources = {1,2,3,4,5,6,7,8,9,10};

    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

}
