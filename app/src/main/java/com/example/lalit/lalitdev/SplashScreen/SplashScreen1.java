package com.example.lalit.lalitdev.SplashScreen;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.crashlytics.android.Crashlytics;
import com.example.lalit.lalitdev.BarChart.Activity.BarCartActivity;
import com.example.lalit.lalitdev.BarChart.Activity.CustomPieChartActivity;
import com.example.lalit.lalitdev.CustomSwapeRecyclerview.Activity.RecyclerDemoActivity;
import com.example.lalit.lalitdev.CustomSwapeRecyclerview.Adapter.CustomSwapeRecyclerViewActivity;
import com.example.lalit.lalitdev.DemoFunctionality.Fragment.CashEqulityFragment;
import com.example.lalit.lalitdev.FacebookIntegrationDemo.Activity.FaceBookDemoActivity;
import com.example.lalit.lalitdev.Fragment.SearchViewFragment;
import com.example.lalit.lalitdev.GCMNotificationDemo.Activity.GCMNotificationActivity;
import com.example.lalit.lalitdev.GoogleMapDemo.Activity.GoogleMapDemoActivity;
import com.example.lalit.lalitdev.GooglePlusDemo.Activity.GooglePlusDemoActivity;
import com.example.lalit.lalitdev.LazyLoadingDemo.Activity.LazyLoaderActivity;
import com.example.lalit.lalitdev.LazyLoadingDemo2.Activity.LazyLoadingDemo2;
import com.example.lalit.lalitdev.MainActivity;
import com.example.lalit.lalitdev.NavigationView.NavigationViewDemo;
import com.example.lalit.lalitdev.NavigationView.NavigationViewInbuild;
import com.example.lalit.lalitdev.PageViewerSwapLayoutDemo.Activity.ViewerPagerActivity;
import com.example.lalit.lalitdev.PageViewerSwapLayoutDemo.Adapter.PageViewerSwapLayoutActivity;
import com.example.lalit.lalitdev.R;
import com.example.lalit.lalitdev.Receiver.DateTimeChangeReceiver;
import com.example.lalit.lalitdev.RecyclerViewDemo.RecyclerViewActivity;
import com.example.lalit.lalitdev.SimpleRecyclerviewExample.Actvity.SimpleRecyclerviewActivity;
import com.example.lalit.lalitdev.SqliteDataBase.FunctinalityInSqliteDataBaseActivity;
import com.example.lalit.lalitdev.StaticNotificatioDemo.Fragment.StaticNotificationActivity;
import com.example.lalit.lalitdev.TabViewWithDrawerLayout.TabviewdraweLayout;
import com.example.lalit.lalitdev.TwitterLoginDemo.Activity.LoginWithTwitterDemoActivity;
import com.example.lalit.lalitdev.VolleyDemo.Activity.VolleyDemoActivity;

import io.fabric.sdk.android.Fabric;

/**
 * Created by lalit on 9/14/2017.
 * sha1 uel is- https://stackoverflow.com/questions/27609442/how-to-get-the-sha-1-fingerprint-certificate-in-android-studio-for-debug-mode
 * Dubug SHA1 key is- https://stackoverflow.com/questions/27609442/how-to-get-the-sha-1-fingerprint-certificate-in-android-studio-for-debug-mode
 *  https://github.com/shinobicontrols/charts-pie-chart-labels-android
 */

public class SplashScreen1 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_splashscreen);

        new CountDownTimer(5000, 1000) {
            public void onFinish() {
                Intent startActivity = new Intent(SplashScreen1.this,VolleyDemoActivity.class);
                startActivity(startActivity);
                finish();
            }
            public void onTick(long millisUntilFinished) {
            }
        }.start();
    }
}
