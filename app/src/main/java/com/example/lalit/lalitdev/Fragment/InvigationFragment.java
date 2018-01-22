package com.example.lalit.lalitdev.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lalit.lalitdev.R;

/**
 * Created by lalit on 9/25/2017.
 */

public class InvigationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.invittigation_fragment, container, false);
     //   return inflater.inflate(R.layout.invittigation_fragment, container, false);
        return view;
    }
}
