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
 * Creates a SQLite Database to handle movies
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 3;

    // Database Name
    private static final String DATABASE_NAME = "moomie";

    // Movies table name
    private static final String TABLE_MOVIES = "movies";

    // Movies table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_YEAR = "year";
    private static final String KEY_RATING = "rating";
    private static final String KEY_DIRECTOR = "director";
    private static final String KEY_ACTORS = "actors";
    private static final String KEY_PLOT = "plot";
    private static final String KEY_POSTER_URL = "posterURL";
    private static final String KEY_MOOMIE_RATING = "moomieRating";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MOVIES_TABLE = "CREATE TABLE " + TABLE_MOVIES + "("
                + KEY_ID + " TEXT," + KEY_TITLE + " TEXT," + KEY_YEAR + " TEXT," + KEY_RATING + " TEXT," + KEY_DIRECTOR + " TEXT," + KEY_ACTORS + " TEXT,"
                + KEY_PLOT + " TEXT," + KEY_POSTER_URL + " TEXT," + KEY_MOOMIE_RATING + " INTEGER" + ")";
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
        values.put(KEY_ID, movie.getID()); //IMDB ID
        values.put(KEY_TITLE, movie.getTitle()); // Movie Title
        values.put(KEY_YEAR, movie.getYear()); // Movie Release year
        values.put(KEY_RATING, movie.getRating()); // Movie Rating
        values.put(KEY_DIRECTOR, movie.getDirector()); // Movie Director
        values.put(KEY_ACTORS, movie.getActors()); // Movie Actors
        values.put(KEY_PLOT, movie.getPlot()); // Movie Plot
        values.put(KEY_POSTER_URL, movie.getPosterURL()); // URL to poster
        values.put(KEY_MOOMIE_RATING, movie.getMoomieRating()); //Moomie Rating

        db.insert(TABLE_MOVIES, null, values);
        db.close(); // Close the database connection
    }

    // Get a single movie
    public MovieObject getMovieObject(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_MOVIES, new String[]{KEY_ID,
                        KEY_TITLE, KEY_YEAR, KEY_RATING, KEY_DIRECTOR, KEY_ACTORS, KEY_PLOT, KEY_POSTER_URL, KEY_MOOMIE_RATING}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        // return Movie
        return new MovieObject(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6),cursor.getString(7));
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
                movie.setID(cursor.getString(0));
                movie.setTitle(cursor.getString(1));
                movie.setYear(cursor.getString(2));
                movie.setRating(cursor.getString(3));
                movie.setDirector(cursor.getString(4));
                movie.setActors(cursor.getString(5));
                movie.setPlot(cursor.getString(6));
                movie.setPosterURL(cursor.getString(7));
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
        values.put(KEY_TITLE, movie.getTitle()); // Movie Title
        values.put(KEY_YEAR, movie.getYear()); // Movie Release year
        values.put(KEY_RATING, movie.getRating()); // Movie Rating
        values.put(KEY_DIRECTOR, movie.getDirector()); // Movie Director
        values.put(KEY_ACTORS, movie.getActors()); // Movie Actors
        values.put(KEY_PLOT, movie.getPlot()); // Movie Plot
        values.put(KEY_POSTER_URL, movie.getPosterURL()); // URL to poster
        values.put(KEY_MOOMIE_RATING, movie.getMoomieRating()); //Moomie Rating

        // updating row
        return db.update(TABLE_MOVIES, values, KEY_ID + " = ?",
                new String[] { movie.getID() });
    }

    // Delete a single MovieObject
    public void deleteMovieObject(MovieObject movie) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MOVIES, KEY_ID + " = ?",
                new  String[] { movie.getID() });
    }
}
