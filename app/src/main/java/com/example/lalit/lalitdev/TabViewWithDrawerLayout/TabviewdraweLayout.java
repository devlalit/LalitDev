package com.example.lalit.lalitdev.TabViewWithDrawerLayout;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.lalit.lalitdev.CustomRecycleViewDemo.CustomRecycleViewGridView;
import com.example.lalit.lalitdev.Fragment.InvigationFragment;
import com.example.lalit.lalitdev.Fragment.Paramount2;
import com.example.lalit.lalitdev.Fragment.Paramount3;
import com.example.lalit.lalitdev.R;

/**
 * Created by lalit on 9/26/2017.
 */

public class TabviewdraweLayout extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //Defining Variables
    NavigationView navigationView;
    Fragment fragment;
    ActionBar actionbar;
    Toolbar toolbar;
    DrawerLayout drawer;
    TextView t1Txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.tab_drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        toggle.syncState();


        FragmentManager fm = getFragmentManager();
        fragment = fm.findFragmentByTag("myFragmentTag");
        if (fragment == null) {
            FragmentTransaction ft = fm.beginTransaction();
            fragment = new CustomRecycleViewGridView();
            //   ft.add(android.R.id.content, fragment, "myFragmentTag");
            ft.replace(R.id.content, fragment);
            ft.commit();
        }

        t1Txt=(TextView)findViewById(R.id.t1_txt);
        t1Txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                fragment = fm.findFragmentByTag("myFragmentTag");
                FragmentTransaction ft = fm.beginTransaction();
                fragment = new InvigationFragment();
                ft.replace(R.id.content, fragment);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
            FragmentManager fm = getFragmentManager();
            fragment = fm.findFragmentByTag("myFragmentTag1");
            FragmentTransaction ft = fm.beginTransaction();
            fragment = new Paramount2();
            ft.replace(R.id.content, fragment);
            ft.addToBackStack(null);
            ft.commit();

            //do something
        } else if (id == R.id.nav_gallery) {
            FragmentManager fm = getFragmentManager();
            fragment = fm.findFragmentByTag("myFragmentTag2");
            FragmentTransaction ft = fm.beginTransaction();
            fragment = new Paramount3();
            ft.replace(R.id.content, fragment);
            ft.addToBackStack(null);
            ft.commit();

            //do something
        } else if (id == R.id.nav_slideshow) {
            FragmentManager fm = getFragmentManager();
            fragment = fm.findFragmentByTag("myFragmentTag3");
            if (fragment == null) {
                FragmentTransaction ft = fm.beginTransaction();
                fragment = new InvigationFragment();
                ft.replace(R.id.content, fragment);
                ft.addToBackStack(null);
                ft.commit();
            } else {

            }
            //do something
        } else if (id == R.id.nav_manage) {
            //do something
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}

