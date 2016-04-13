package com.example.brianberg.moomie2;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.Profile;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.EnumSet;

import android.appwidget.AppWidgetProvider;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.Button;
import android.os.Bundle;


/**
 * A simple {@link Fragment} subclass.
 */
public class Profile_Fragment extends Fragment {


    public Profile_Fragment() {
        // Required empty public constructor
    }

//    public void onCreate(Bundle SavedInstanceState){
//        super.onCreate(SavedInstanceState);
//
//    }

//    public static Bitmap getFacebookProfilePicture(String userID){
//
//
//        URL imageURL = null;
//        try {
//            imageURL = new URL("https://graph.facebook.com/" + userID + "/picture?type=large");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//
//
//        Bitmap bitmap = null;
//        try {
//            bitmap = BitmapFactory.decodeStream(imageURL.openConnection().getInputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return bitmap;
//    }
//
//    Bitmap bitmap = getFacebookProfilePicture(Profile.getCurrentProfile().getId());


//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_menu, container, false);


        //ImageView imageView = (ImageView) view.findViewById(R.id.my_image);
        // Inflate the layout for this fragment
      //  return inflater.inflate(R.layout.fragment_profile, container, false);

//        ProfilePictureView profilePicture;
//        profilePicture = (ProfilePictureView) getView().findViewById(R.id.profile_Picture);
//        profilePicture.setProfileId(Profile.getCurrentProfile().getId());
//        profilePicture.setDefaultProfilePicture(bitmap);
//        String profile = Profile.getCurrentProfile().getId();
//
//        ProfilePictureView profilePicture;
//        profilePicture = (ProfilePictureView) view.findViewById(R.id.profile_Picture);
//        //profilePicture.setProfileId(profile);
//        profilePicture.setDefaultProfilePicture(bitmap);
//
//       // return inflater.inflate(R.layout.fragment_profile, container, false);
//        return view;

        ImageView image =(ImageView) (view.findViewById(R.id.imageView));
        if(Profile.getCurrentProfile()!=null)
        {
            try {

                //Uri uri = (Profile.getCurrentProfile().getProfilePictureUri(100, 150));
                URL url = new URL(Profile.getCurrentProfile().getProfilePictureUri(100, 150).toString());
                Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                //Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
                image.setImageBitmap(bitmap);
                image.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            catch(FileNotFoundException f)
            {
                Log.e("FNF Exception","Profile Picture");
            }
            catch(IOException i)
            {
                Log.e("IO Exception", "Profile Picture");
            }
        }
        //((TextView)view.findViewById(R.id.textView)).setText(Profile.getCurrentProfile().getName());
        ((ProfilePictureView)view.findViewById(R.id.profile_Picture)).setProfileId(
                Profile.getCurrentProfile().getId()
        );
        return view;
    }






}
