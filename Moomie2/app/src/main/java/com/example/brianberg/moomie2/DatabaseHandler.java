package com.example.brianberg.moomie2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jerry Sommerfeld on 3/29/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "moomie";

    // Movies table name
    private static final String TABLE_MOVIES = "movies";

    // Movies table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_PLOT = "plot";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MOVIES_TABLE = "CREATE TABLE " + TABLE_MOVIES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TITLE + " TEXT,"
                + KEY_PLOT + " TEXT" + ")";
        db.execSQL(CREATE_MOVIES_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MOVIES);

        // Create tables again
        onCreate(db);
    }

    // Add a new movie
    public void addMovieObject(MovieObject movie) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, movie.getTitle()); // Movie Title
        values.put(KEY_PLOT, movie.getPlot()); // Movie Plot

        db.insert(TABLE_MOVIES, null, values);
        db.close(); // Close the database connection
    }

    // Get a single movie
    public MovieObject getMovieObject(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_MOVIES, new String[]{KEY_ID,
                        KEY_TITLE, KEY_PLOT}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        MovieObject movie = new MovieObject(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return Movie
        return movie;
    }

    // Get a list of all movies
    public List<MovieObject> getAllMovieObjects() {
        List<MovieObject> movieList = new ArrayList<MovieObject>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_MOVIES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Looping through all rows and adding to the list
        if(cursor.moveToFirst()) {
            do {
                MovieObject movie = new MovieObject();
                movie.setID(Integer.parseInt(cursor.getString(0)));
                movie.setTitle(cursor.getString(1));
                movie.setPlot(cursor.getString(2));
                // Adding movie to list
                movieList.add(movie);
            }while (cursor.moveToNext());
        }

        // Return the MovieObject List
        return movieList;
    }

    // Get the MovieObjects count
    public int getMovieObjectCount() {
        String countQuery = "SELECT  * FROM " + TABLE_MOVIES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    // Update a single MovieObject
    public int updateMovieObject(MovieObject movie) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, movie.getTitle());
        values.put(KEY_PLOT, movie.getPlot());

        // updating row
        return db.update(TABLE_MOVIES, values, KEY_ID + " = ?",
                new String[] { String.valueOf(movie.getID()) });
    }

    // Delete a single MovieObject
    public void deleteMovieObject(MovieObject movie) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MOVIES, KEY_ID + " = ?",
                new  String[] { String.valueOf((movie.getID())) });
    }
}
