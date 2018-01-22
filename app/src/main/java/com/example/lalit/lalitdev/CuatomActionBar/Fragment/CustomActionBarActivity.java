package com.example.lalit.lalitdev.CuatomActionBar.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lalit.lalitdev.R;

/**
 * Created by Admin on 12/14/2017.
 */

public class CustomActionBarActivity extends Fragment {
    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.fragment_fragmentclasstructure_layout, null);
        initViews();
        return rootView;
    }
    public void initViews(){

    }
}
