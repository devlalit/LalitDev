package com.example.lalit.lalitdev.SimpleRecyclerviewExample.Actvity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lalit.lalitdev.R;
import com.example.lalit.lalitdev.SimpleRecyclerviewExample.Adapter.MyRecyclerViewAdapter;

import java.util.ArrayList;

/**
 * Created by Admin on 1/5/2018.
 */

public class SimpleRecyclerviewActivity extends AppCompatActivity  {

    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slow_moving_inventory_layout);

        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsingToolbar);

        collapsingToolbarLayout.setTitle("Invetory Details");
        collapsingToolbarLayout.setExpandedTitleColor(Color.parseColor("#00000000")); // transperent color = #00000000
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.white)); //Color of your title


        // data to populate the RecyclerView with
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");

        // set up the RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.companyListRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, animalNames);
        recyclerView.setAdapter(adapter);
    }


}
