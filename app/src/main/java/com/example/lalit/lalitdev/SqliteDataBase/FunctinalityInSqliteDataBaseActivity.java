package com.example.lalit.lalitdev.SqliteDataBase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lalit.lalitdev.R;

/**
 * Created by lalit on 11/23/2017.
 * https://www.journaldev.com/9438/android-sqlite-database-example-tutorial
 */

public class FunctinalityInSqliteDataBaseActivity extends Activity implements View.OnClickListener{
    private Button addTodoBtn;
    private EditText subjectEditText;
    private EditText descEditText;

    private DBManager dbManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_functinality_sqlitedatabase_layout);
        //Get User records from SQLite DB
        initViews();
    }
    public  void initViews(){
        subjectEditText = (EditText) findViewById(R.id.subject_edittext);
        descEditText = (EditText) findViewById(R.id.description_edittext);

        addTodoBtn = (Button) findViewById(R.id.add_record);

        dbManager = new DBManager(this);
        dbManager.open();
        addTodoBtn.setOnClickListener(FunctinalityInSqliteDataBaseActivity.this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_record:

                final String name = subjectEditText.getText().toString();
                final String desc ="24-Dec-2017";


                if( dbManager.insert(name, desc)){
                    Toast.makeText(this, "New row added, row id: ", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Something wrong", Toast.LENGTH_SHORT).show();
                }
                Intent main = new Intent(FunctinalityInSqliteDataBaseActivity.this, CountryListActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(main);
                break;
        }
    }
}