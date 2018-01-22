package com.example.lalit.lalitdev.ActivitieClassStructure;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.lalit.lalitdev.R;

/**
 * Created by lalit on 11/2/2017.
 */

public class ActivityClassStructure extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_fragmentclasstructure_layout);

        initViews();
    }
      public  void initViews(){
    }
}
