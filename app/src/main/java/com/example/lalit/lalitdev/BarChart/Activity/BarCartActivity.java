package com.example.lalit.lalitdev.BarChart.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.lalit.lalitdev.R;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by lalit on 11/23/2017.
 * https://stackoverflow.com/questions/9741300/charts-for-android
 * https://www.android-examples.com/pie-chart-graph-android-app-using-mpandroidchart/
 * http://www.blazin.in/2013/06/drawing-3d-piechart-using-google-chart.html
 *
 * https://androidtutorialmagic.wordpress.com/android-drawing-chart-and-touch-tutorial/custom-pie-chart-tutorial/
 *
 * http://android-pratap.blogspot.in/2016/04/create-piechart-using-mpandroidchart.html
 */
public class BarCartActivity  extends AppCompatActivity {

    PieChart pieChart ;
    ArrayList<Entry> entries ;
    ArrayList<String> PieEntryLabels;
    PieDataSet pieDataSet;
    PieData pieData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barchar_layout);

        pieChart = (PieChart) findViewById(R.id.chart1);

        entries = new ArrayList<>();

        PieEntryLabels = new ArrayList<String>();

        AddValuesToPIEENTRY();

        AddValuesToPieEntryLabels();

        pieDataSet = new PieDataSet(entries, "");

        pieData = new PieData(PieEntryLabels, pieDataSet);

        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        pieChart.setData(pieData);

        pieChart.animateY(3000);
    }
    public void AddValuesToPIEENTRY(){
        entries.add(new BarEntry(2f, 0));
        entries.add(new BarEntry(4f, 1));
        entries.add(new BarEntry(6f, 2));
        entries.add(new BarEntry(8, 3));
        entries.add(new BarEntry(7f, 4));
      //  entries.add(new BarEntry(3f, 5));
      //  entries.add(new BarEntry(3f, 5));
    }
    public void AddValuesToPieEntryLabels(){
        PieEntryLabels.add("January");
        PieEntryLabels.add("February");
        PieEntryLabels.add("March");
        PieEntryLabels.add("April");
        PieEntryLabels.add("May");
    //  PieEntryLabels.add("June");
    //  PieEntryLabels.add("May");
    }
}
