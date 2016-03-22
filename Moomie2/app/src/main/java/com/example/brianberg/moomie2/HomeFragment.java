package com.example.brianberg.moomie2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
/**
 * Created by BrianBerg on 3/15/16.
 */
public class HomeFragment extends AppCompatActivity {
    View view;
    FragmentManager fragmentManager = getFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment mainFragment = new Fragment();

        fragmentTransaction.add(R.id.fragment, mainFragment);
        fragmentTransaction.addToBackStack(null);

        //fragmentTransaction.replace(R.id.contentPanel, mainFragment);
        fragmentTransaction.replace(R.id.contentPanel, mainFragment);
        fragmentTransaction.commit();
        //replace(MainFragment);
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

}
