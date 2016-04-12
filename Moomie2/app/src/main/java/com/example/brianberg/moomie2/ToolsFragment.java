package com.example.brianberg.moomie2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ToolsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ToolsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ToolsFragment extends Fragment {

    public ToolsFragment(){
        // Leave empty
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Switch the image with url
        ImageView ImageToSwitch = (ImageView) getView().findViewById(R.id.ImageToSwitch);
        // Get Drawable from URL
        try{
            Log.d("Working", "Working");
            System.out.println("Working");
            InputStream is = (InputStream) new URL("https://s-media-cache-ak0.pinimg.com/736x/66/b4/1c/66b41c8b9f57e17150eba935791ca4ef.jpg").getContent();
            Drawable d = Drawable.createFromStream(is,"https://s-media-cache-ak0.pinimg.com/736x/66/b4/1c/66b41c8b9f57e17150eba935791ca4ef.jpg");
            ImageToSwitch.setImageDrawable(d);
            Log.d("Working", "Working");
            System.out.println("Working");
        }
        catch (MalformedURLException e) {
        e.printStackTrace();
        } catch (IOException e) {
        e.printStackTrace();
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tools, container, false);
    }
}
