package com.example.brianberg.moomie2;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * A simple {@link Fragment} subclass.
 */
public class Profile_Fragment extends Fragment {


    public Profile_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

//    public static Bitmap getFacebookProfilePicture(String userID){
//        try {
//            URL imageURL = new URL("https://graph.facebook.com/" + userID + "/picture?type=large");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        Bitmap bitmap = BitmapFactory.decodeStream(imageUrl.openConnection().getInputStream());
//
//        return bitmap;
//    }
//
//    Bitmap bitmap = getFacebookProfilePicture(userId);
//
}
