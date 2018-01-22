package com.example.lalit.lalitdev.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.lalit.lalitdev.NavigationView.NavigationViewInbuild;
import com.example.lalit.lalitdev.R;

/**
 * Created by lalit on 9/25/2017.
 */

public class Paramount2  extends Fragment {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.paramount2, container, false);
        // Set up your ActionBar
        ((NavigationViewInbuild) getActivity()).toolbar.setVisibility(View.GONE);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowCustomEnabled(true);



        ((AppCompatActivity)getActivity()).getSupportActionBar().setCustomView(R.layout.custom_action_bar_layout);
        View view =((AppCompatActivity)getActivity()).getSupportActionBar().getCustomView();

        ImageButton imageButton= (ImageButton)view.findViewById(R.id.action_bar_back);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        return view;
    }
}