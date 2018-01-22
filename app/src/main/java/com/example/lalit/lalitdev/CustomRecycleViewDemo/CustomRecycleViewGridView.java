package com.example.lalit.lalitdev.CustomRecycleViewDemo;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lalit.lalitdev.R;

import java.util.ArrayList;

/**
 * Created by lalit on 9/27/2017.
 * https://www.learn2crack.com/2016/03/grid-recyclerview-with-images-and-text.html
 */

public class CustomRecycleViewGridView extends Fragment {

    private final String android_version_names[] = {
            "Donut",
            "Eclair",
            "Froyo",
            "Gingerbread",
            "Honeycomb",
            "Ice Cream Sandwich",
            "Jelly Bean",
            "KitKat",
            "Marshmallow"
    };
    private final int android_image_urls[] = {
            R.drawable.camera_icon2,
            R.drawable.camera_icon2,
            R.drawable.camera_icon2,
            R.drawable.camera_icon2,
            R.drawable.camera_icon2,
            R.drawable.camera_icon2,
            R.drawable.camera_icon2,
            R.drawable.camera_icon2,
            R.drawable.camera_icon2
    };
    View view;
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

                view=inflater.inflate(R.layout.recycleview, container, false);

        initViews();
        onClickEvent();
        return view;
    }
    private void initViews(){
        recyclerView = (RecyclerView)view.findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);

        int spanCount = 2; // 3 columns
        int spacing = 50; // 50px
        boolean includeEdge = false;
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));

        ArrayList<AndroidVersion> androidVersions = prepareData();
        DataAdapter adapter = new DataAdapter(getActivity(),androidVersions);
        recyclerView.setAdapter(adapter);
    }
    public void onClickEvent(){
    }
    private ArrayList<AndroidVersion> prepareData(){
        ArrayList<AndroidVersion> android_version = new ArrayList<>();
        for(int i=0;i<android_version_names.length;i++){
            AndroidVersion androidVersion = new AndroidVersion();
            androidVersion.setAndroid_version_name(android_version_names[i]);
            androidVersion.setAndroid_image_url(android_image_urls[i]);
            android_version.add(androidVersion);
        }
        return android_version;
    }
}
