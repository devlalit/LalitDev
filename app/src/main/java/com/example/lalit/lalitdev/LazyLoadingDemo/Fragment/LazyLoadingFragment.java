package com.example.lalit.lalitdev.LazyLoadingDemo.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lalit.lalitdev.CustomRecycleViewDemo.AndroidVersion;
import com.example.lalit.lalitdev.LazyLoadingDemo.Adapter.LazyLoaderAdapter;
import com.example.lalit.lalitdev.LazyLoadingDemo.Modle.LazyLoader;
import com.example.lalit.lalitdev.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lalit on 11/2/2017.
 * http://www.coderzheaven.com/2012/09/23/simplest-lazy-loading-listview-android-data-populated-mysql-database-php/
 */

public class LazyLoadingFragment  extends Fragment {
    View rootView;
    private final String android_version_names[] = {
            "Donut",
            "Eclair",
            "Froyo",
            "Gingerbread",
            "Honeycomb",
            "Ice Sandwich",
            "Jelly Bean",
            "KitKat",
            "Lollipop",
            "Marshmallow"
    };

    private final String android_image_urls[] = {
            "http://api.learn2crack.com/android/images/donut.png",
            "http://api.learn2crack.com/android/images/eclair.png",
            "http://api.learn2crack.com/android/images/froyo.png",
            "http://api.learn2crack.com/android/images/ginger.png",
            "http://api.learn2crack.com/android/images/honey.png",
            "http://api.learn2crack.com/android/images/icecream.png",
            "http://api.learn2crack.com/android/images/jellybean.png",
            "http://api.learn2crack.com/android/images/kitkat.png",
            "http://api.learn2crack.com/android/images/lollipop.png",
            "http://api.learn2crack.com/android/images/marshmallow.png"
    };
    List<String> list = new ArrayList<String>();
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.fragment_lazyloadingfragment_layout, null);
        initViews();
        return rootView;
    }
    public void initViews(){
        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList androidVersions = prepareData();
        LazyLoaderAdapter lazyLoaderAdapter = new LazyLoaderAdapter(getActivity(),androidVersions);
        recyclerView.setAdapter(lazyLoaderAdapter);
    }
    private ArrayList prepareData(){

        ArrayList android_version = new ArrayList<>();
        for(int i=0;i<android_version_names.length;i++){
            LazyLoader lazyLoader = new LazyLoader();
            lazyLoader.setAndroid_version_name(android_version_names[i]);
            lazyLoader.setAndroid_image_url(android_image_urls[i]);
            android_version.add(lazyLoader);
        }
        return android_version;
    }
}
