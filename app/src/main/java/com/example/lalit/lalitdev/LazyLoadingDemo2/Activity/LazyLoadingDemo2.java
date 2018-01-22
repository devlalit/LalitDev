package com.example.lalit.lalitdev.LazyLoadingDemo2.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lalit.lalitdev.LazyLoadingDemo.Adapter.LazyLoaderAdapter;
import com.example.lalit.lalitdev.LazyLoadingDemo.Modle.LazyLoader;
import com.example.lalit.lalitdev.LazyLoadingDemo2.POJO.Data;
import com.example.lalit.lalitdev.R;

import java.util.ArrayList;

/**
 * Created by Admin on 12/6/2017.
 */

public class LazyLoadingDemo2 extends Activity {
    ArrayList<Data> dataArrayList;
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
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_lazyloadingfragment_layout);
        //Get User records from SQLite DB
        initViews();
    }
    public  void initViews(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList androidVersions = prepareData();
        LazyLoaderAdapter lazyLoaderAdapter = new LazyLoaderAdapter(this,androidVersions);
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


    //==============================================================================================
 /* private void prepareDummyDataForLoading() {
        dataArrayList.add(new Data("", "", "", ContextCompat.getDrawable(LazyLoadingDemo2.this, R.drawable.city), true));
        dataArrayList.add(new Data("", "", "", ContextCompat.getDrawable(LazyLoadingDemo2.this, R.drawable.city), true));
        dataArrayList.add(new Data("", "", "", ContextCompat.getDrawable(LazyLoadingDemo2.this, R.drawable.city), true));
        dataArrayList.add(new Data("", "", "", ContextCompat.getDrawable(LazyLoadingDemo2.this, R.drawable.city), true));
        dataArrayList.add(new Data("", "", "", ContextCompat.getDrawable(LazyLoadingDemo2.this, R.drawable.city), true));
        dataArrayList.add(new Data("", "", "", ContextCompat.getDrawable(LazyLoadingDemo2.this, R.drawable.city), true));
        dataArrayList.add(new Data("", "", "", ContextCompat.getDrawable(LazyLoadingDemo2.this, R.drawable.city), true));
    }
    private void prepareSomeDataForLoading() {
        dataArrayList.add(new Data("First City", "First State", "First Country", ContextCompat.getDrawable(MainActivity.this, R.drawable.city), false));
        dataArrayList.add(new Data("Secnd City", "Secnd State", "Secnd Country", ContextCompat.getDrawable(MainActivity.this, R.drawable.city), false));
        dataArrayList.add(new Data("Thrd City", "Thrd State", "Thrd Country", ContextCompat.getDrawable(MainActivity.this, R.drawable.city), false));
        dataArrayList.add(new Data("Fourth City", "Fourth State", "Fourth Country", ContextCompat.getDrawable(MainActivity.this, R.drawable.city), false));
        dataArrayList.add(new Data("Fifth City", "Fifth State", "Fifth Country", ContextCompat.getDrawable(MainActivity.this, R.drawable.city), false));
        dataArrayList.add(new Data("Sixh City", "Sixh State", "Sixh Country", ContextCompat.getDrawable(MainActivity.this, R.drawable.city), false));
        dataArrayList.add(new Data("Sevn City", "Sevn State", "Sevn Country", ContextCompat.getDrawable(MainActivity.this, R.drawable.city), false));
    }*/


}
