package com.example.lalit.lalitdev.NavigationView;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.lalit.lalitdev.ActivitieClassStructure.ActivityClassStructure;
import com.example.lalit.lalitdev.FragmentClassStructure.FragmentClassStructure;
import com.example.lalit.lalitdev.R;

/**
 * Created by lalit on 1/30/2018.
 */

public class NavigationFragmentClass extends Fragment {
    View rootView;
    private Button btnFragmentCall,btnIntentCall;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.fragment_navigationdemo_layout, null);
        initViews();
        return rootView;
    }
    public void initViews(){
        btnFragmentCall=(Button)rootView.findViewById(R.id.btnFragmentCall);
        btnFragmentCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment newFragment = new FragmentClassStructure();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        btnIntentCall=(Button)rootView.findViewById(R.id.btnIntentCall);
        btnIntentCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), ActivityClassStructure.class);
                startActivity(intent);
            }
        });

    }
}

