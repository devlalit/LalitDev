package com.example.lalit.lalitdev.BarChart.Activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import android.view.Menu;
import android.widget.LinearLayout;

import com.example.lalit.lalitdev.BarChart.Demo;

import com.example.lalit.lalitdev.R;
import com.github.mikephil.charting.charts.PieChart;

/**
 * Created by lalit on 12/4/2017.
 */
public class CustomPieChartActivity extends Activity {

    Demo pieChart;
    LinearLayout linearLayout;
    //int[] data={6,5,8,4,7,6};
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_pie_chart_layout);
        int[] data={6,5,8,4,7,6};
        int[] color={Color.RED,Color.BLUE,Color.CYAN,Color.GREEN,Color.MAGENTA, Color.GREEN};
        linearLayout=(LinearLayout)findViewById(R.id.linearLayout);
      //  linearLayout.addView(new PieChart(CustomPieChartActivity.this,6,data,color));
        linearLayout.addView(new Demo(this,6,data,color));
    }
}