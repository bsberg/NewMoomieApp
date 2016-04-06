package com.example.brianberg.moomie2;

import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AddMovieActivity extends AppCompatActivity {
    EditText ed1, ed2, ed3, ed4, ed5, ed6;

    private String url1 = "http://www.omdbapi.com/?t=";
    private String url2 = "&y=&plot=short&r=xml";
    private HandleXML obj;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_movie);
        final DatabaseHandler db = new DatabaseHandler(this);

        b1 = (Button)findViewById(R.id.button);

        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);
        ed3 = (EditText)findViewById(R.id.editText3);
        ed4 = (EditText)findViewById(R.id.editText4);
        ed5 = (EditText)findViewById(R.id.editText5);
        ed6 = (EditText)findViewById(R.id.editText6);

        b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    String url = ed1.getText().toString();
                    url = url.replaceAll("\\s","+");
                    String finalUrl = url1 + url + url2;
                    ed2.setText(finalUrl);
                    Log.d("OMDB http",finalUrl);

                    obj = new HandleXML(finalUrl);
                    obj.fetchXML();

                    while (obj.parsingComplete);
                    ed2.setText(obj.getID());
                    ed3.setText(obj.getTitle() + " (" + obj.getYear() + ") - " + obj.getRating());
                    ed4.setText(obj.getDirector());
                    ed5.setText(obj.getActors());
                    ed6.setText(obj.getPlot());

                    db.addMovieObject(new MovieObject(obj.getID(), obj.getTitle(), obj.getYear(), obj.getRating(), obj.getDirector(), obj.getActors(), obj.getPlot(), obj.getPosterURL()));
                    // Read all of the movies
                    Log.d("Reading: ", "Reading all movies..");
                    List<MovieObject> movies = db.getAllMovieObjects();

                    for(MovieObject moo : movies) {
                        String log = "Id: " + moo.getID() + ", Title: " + moo.getTitle() + ", Plot: " + moo.getPlot();
                        Log.d("Movies: ", log);
                    }


                }
        });
    }
}
