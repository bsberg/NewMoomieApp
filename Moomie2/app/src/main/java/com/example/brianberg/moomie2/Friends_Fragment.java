package com.example.brianberg.moomie2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Friends_Fragment extends Fragment {

    public Friends_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friends_, container, false);

        // Connect to friends through facebook sdk
        Intent intent = getActivity().getIntent();
        String jsondata = intent.getStringExtra("jsondata");
        JSONArray friendsList;
        ArrayList<String> friends = new ArrayList<String>();
        //friends.add("Neil");
        //friends.add("Prakhar");

        // Populate ArrayList
        try {
            friendsList = new JSONArray(jsondata);
            for (int i = 0; i < friendsList.length(); i++) {
                friends.add(friendsList.getJSONObject(i).getString("name"));
            }
        }catch (JSONException e){
            e.printStackTrace();
        }

        // Attach to listview to adapter
        ListView listView = (ListView) view.findViewById(R.id.friends_list_view);
        FriendAdapter adapter = new FriendAdapter(getContext(), friends);
        listView.setAdapter(adapter);

        return view;
    }

}
