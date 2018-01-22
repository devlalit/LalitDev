package com.example.lalit.lalitdev.SqliteDataBase;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.lalit.lalitdev.R;

import org.apache.commons.logging.Log;

/**
 * Created by lalit on 11/24/2017.
 */

public class CountryListActivity extends Activity {

    private DBManager dbManager;

    private ListView listView;

    private SimpleCursorAdapter adapter;

    final String[] from = new String[] { DatabaseHelper._ID,
            DatabaseHelper.SUBJECT, DatabaseHelper.DESC };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_emp_list_layout);

        dbManager = new DBManager(this);
        dbManager.open();
        Cursor cursor = dbManager.fetch();

        listView = (ListView) findViewById(R.id.list_view);

        System.out.println("the fetch  record id that======="+cursor.getString( cursor.getColumnIndex("description")));
        System.out.println("the fetch  record id that======="+cursor.getCount());
        while (cursor.moveToNext()) {
            System.out.println("the fetch  record id that======="+cursor.getString( cursor.getColumnIndex("description")));
        }

}
}
