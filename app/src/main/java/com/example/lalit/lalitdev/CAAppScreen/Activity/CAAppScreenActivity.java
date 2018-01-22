package com.example.lalit.lalitdev.CAAppScreen.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.lalit.lalitdev.R;

/**
 * Created by Admin on 1/5/2018.
 */

public class CAAppScreenActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_fragmentclasstructure_layout);
        //Get User records from SQLite DB
        initViews();
    }
    public  void initViews(){
    }
}

