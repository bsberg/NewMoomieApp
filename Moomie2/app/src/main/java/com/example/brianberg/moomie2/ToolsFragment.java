package com.example.brianberg.moomie2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ToolsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ToolsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ToolsFragment extends Fragment {
    Bitmap bitmap = null;
    String url = "https://s-media-cache-ak0.pinimg.com/736x/66/b4/1c/66b41c8b9f57e17150eba935791ca4ef.jpg";
    //Message msg = null;

    public ToolsFragment(){
        // Leave empty
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Switch the image with url
        View view = inflater.inflate(R.layout.fragment_tools, container, false);
        try {
            TextView text = (TextView) view.findViewById(R.id.SaltText);
            text.setText("Hello World");
            ImageView ImageToSwitch = (ImageView) view.findViewById(R.id.ImageToSwitch);
            Log.d("toolsFragmentStart: ", "ImageView Found");
            ImageToSwitch.setImageResource(R.drawable.cow);
            Log.d("toolsFragmentStart: ", "Changed Image");
        }
        catch(Exception e){
            Log.d("Tools Fragment", "NullPointerException");
        }

        // Get Drawable from URL
        /*try{
            Log.d("ToolsFragment", "Getting Movie from URL");
            InputStream in = openHttpConnection(url);

            /*URL url = new URL("https://s-media-cache-ak0.pinimg.com/736x/66/b4/1c/66b41c8b9f57e17150eba935791ca4ef.jpg");
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            ImageView ImageTooSwitch = (ImageView) view.findViewById(R.id.ImageToSwitch);
            ImageTooSwitch.setImageBitmap(bmp);*/
            /*URL url = new URL("http://ia.media-imdb.com/images/M/MV5BMTk3NDE2NzI4NF5BMl5BanBnXkFtZTgwNzE1MzEyMTE@._V1_SX300.jpg");
            InputStream is = (InputStream) url.getContent();
            Log.d("ToolsFragment", "got InputStream");

            Drawable d = Drawable.createFromStream(is,"http://ia.media-imdb.com/images/M/MV5BMTk3NDE2NzI4NF5BMl5BanBnXkFtZTgwNzE1MzEyMTE@._V1_SX300.jpg");
            Log.d("ToolsFragment", "got drawable");

            ImageView ImageTooSwitch = (ImageView) view.findViewById(R.id.ImageToSwitch);
            ImageTooSwitch.setImageDrawable(d);
            Log.d("ToolsFragment", "URL process working");
        }
        catch (MalformedURLException e) {
        e.printStackTrace();
        } catch (IOException e) {
            Log.d("ToolsFragment", "Error URL I/O Process");
            e.printStackTrace();
        } catch (Exception e) {
            Log.d("ToolsFragment", "Error URL Process");
            e.printStackTrace();
        }*/
        new Thread() {
            public void run() {
                InputStream in = null;

                //msg = Message.obtain();
                //msg.what = 1;

                try {
                    Log.d("ToolsFragment: ", url);
                    in = openHttpConnection(url);
                    bitmap = BitmapFactory.decodeStream(in);

                    // ImageView ImageTooSwitch = (ImageView) view.findViewById(R.id.ImageToSwitch);
                    Bundle b = new Bundle();
                    //b.putParcelable("bitmap", bitmap);
                    //msg.setData(b);
                    in.close();
                }
                catch (IOException e1) {
                    e1.printStackTrace();
                }
                //messageHandler.sendMessage(msg);
            }
        }.start();

        try{
            Thread.sleep(300);
        }catch (InterruptedException e){
            Log.d("ToolsFragment","InterruptedException");
        }

        ImageView ImageTooSwitch = (ImageView) view.findViewById(R.id.ImageToSwitch);
        ImageTooSwitch.setImageBitmap(bitmap);
        if(bitmap == null) Log.d("ToolsFragment:", "Bitmap == null");
        Log.d("ToolsFragment", "Bitmapp worked");
        // Inflate the layout for this fragment
        return view;
    }

    private InputStream openHttpConnection(String urlString){
        InputStream in = null;
        int resCode = -1;

        try {
            URL url = new URL(urlString);
            URLConnection urlConn = url.openConnection();
            if(!(urlConn instanceof HttpURLConnection)) {
                throw new IOException("Url is not an Http URL");
            }
            HttpURLConnection httpConn = (HttpURLConnection) urlConn;
            httpConn.setAllowUserInteraction(false);
            httpConn.setInstanceFollowRedirects(true);
            resCode = httpConn.getResponseCode();

            if (resCode == HttpURLConnection.HTTP_OK) {
                in = httpConn.getInputStream();
            }
        }

        catch (MalformedURLException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        return in;
    }
}
