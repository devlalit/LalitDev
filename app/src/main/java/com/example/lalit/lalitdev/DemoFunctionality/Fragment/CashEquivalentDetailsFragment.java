package com.example.lalit.lalitdev.DemoFunctionality.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lalit.lalitdev.LazyLoadingDemo.Modle.LazyLoader;
import com.example.lalit.lalitdev.LazyLoadingDemo2.POJO.Data;
import com.example.lalit.lalitdev.R;
import com.example.lalit.lalitdev.RecyclerViewDemo.CustomAdapter;
import com.example.lalit.lalitdev.RecyclerViewDemo.DataModel;


import java.util.ArrayList;

/**
 * Created by Admin on 12/8/2017.
 */

public class CashEquivalentDetailsFragment extends Fragment {
    View rootView;
    ArrayList<Data> dataArrayList;
    private static ArrayList<DataModel> data;
    private static ArrayList<Integer> removedItems;
    private static RecyclerView.Adapter adapter;
    private final String android_version_names[] = {
            /*"Donut",
            "Eclair",
            "Froyo",
            "Gingerbread",
            "Honeycomb",
            "Ice Sandwich",
            "Jelly Bean",
            "KitKat",
            "Lollipop",*/
            "Marshmallow"
    };
    private final String android_image_urls[] = {
           /* "http://api.learn2crack.com/android/images/donut.png",
            "http://api.learn2crack.com/android/images/eclair.png",
            "http://api.learn2crack.com/android/images/froyo.png",
            "http://api.learn2crack.com/android/images/ginger.png",
            "http://api.learn2crack.com/android/images/honey.png",
            "http://api.learn2crack.com/android/images/icecream.png",
            "http://api.learn2crack.com/android/images/jellybean.png",
            "http://api.learn2crack.com/android/images/kitkat.png",
            "http://api.learn2crack.com/android/images/lollipop.png",*/
            "http://api.learn2crack.com/android/images/marshmallow.png"
    };
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.fragment_cash_equivalent_details_layout, null);
        initViews();
        return rootView;
    }
    public void initViews(){
        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
      CollapsingToolbarLayout mCollapsingToolbarLayout = (CollapsingToolbarLayout)rootView.findViewById(R.id.collapsing_toolbar);
      mCollapsingToolbarLayout.setTitleEnabled(false);
     /*   ArrayList androidVersions = prepareData();
        LazyLoaderAdapter lazyLoaderAdapter = new LazyLoaderAdapter(getActivity(),androidVersions);
        recyclerView.setAdapter(lazyLoaderAdapter);*/



        recyclerView.setItemAnimator(new DefaultItemAnimator());
        data = new ArrayList<DataModel>();
        for (int i = 0; i <MyData.nameArray.length; i++) {
            data.add(new DataModel(
                    MyData.nameArray[i],
                    MyData.versionArray[i],
                    MyData.id_[i],
                    MyData.drawableArray[i]
            ));
        }


        removedItems = new ArrayList<Integer>();

        adapter = new CustomAdapter(data);
        recyclerView.setAdapter(adapter);




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

