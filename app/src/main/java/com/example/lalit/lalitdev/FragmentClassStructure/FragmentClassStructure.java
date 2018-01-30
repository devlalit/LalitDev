package com.example.lalit.lalitdev.FragmentClassStructure;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lalit.lalitdev.R;

/**
 * Created by lalit on 11/2/2017.
 */

public class FragmentClassStructure  extends Fragment {
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
