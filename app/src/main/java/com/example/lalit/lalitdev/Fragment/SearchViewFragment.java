package com.example.lalit.lalitdev.Fragment;


import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.lalit.lalitdev.R;
import com.example.lalit.lalitdev.SearchView.AnimalNames;
import com.example.lalit.lalitdev.SearchView.ListViewAdapter;

import java.util.ArrayList;

/**
 * Created by lalit on 10/11/2017.
 */

public class SearchViewFragment extends Activity implements SearchView.OnQueryTextListener{
    // Declare Variables
    ListView list;
    ListViewAdapter adapter;
    SearchView editsearch;
    String[] animalNameList;
    Spinner spinner;
    ArrayList<String> abc=new ArrayList<String>();
    ArrayList<AnimalNames> arraylist = new ArrayList<AnimalNames>();
    View view;
    TextView txtSelectName;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_searchview);

      /*  animalNameList = new String[]{""};
        // Locate the ListView in listview_main.xml
       // list = (ListView)view.findViewById(R.id.listview);
        txtSelectName=(TextView)findViewById(R.id.txtSelectName);
        for (int i = 0; i < animalNameList.length; i++) {
            AnimalNames animalNames = new AnimalNames(animalNameList[i]);
            // Binds all strings into an array
            arraylist.add(animalNames);
        }*/
        // Pass results to ListViewAdapter Class
     //   adapter = new ListViewAdapter(this, arraylist);
        // Binds the Adapter to the ListView
     //   list.setAdapter(adapter);
        // Locate the EditText in listview_main.xml
     //   editsearch = (SearchView)view.findViewById(R.id.search);
     //   editsearch.setOnQueryTextListener(this);

        txtSelectName=(TextView)findViewById(R.id.txtSelectName);
        txtSelectName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialog1()  ;
            }
        });
        animalNameList = new String[]{"Lion", "Tiger", "Dog",
                "Cat"};
    }
    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.e("Error", "user login successfully"+1);
        return false;
    }
    @Override
    public boolean onQueryTextChange(String newText) {

        String text = newText;
        if (!text.matches("")){
            webServiceCall();
        }
        return false;
    }
    //popup of forgot password
    public void showDialog1() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.searchview_popup);

        editsearch = (SearchView)dialog.findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);
        list = (ListView)dialog.findViewById(R.id.listview);
        // Button ok = (Button) dialog.findViewById(R.id.ok);
      /*  ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               *//* ServiceManager serviceManager = new ServiceManager(getDialogContext(), SettingsActivity.this);
                serviceManager.unSubscryOffer(db.getOfferId());*//*
                dialog.dismiss();
            }
        });
        Button close = (Button) dialog.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();*/
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //    String selectedFromList =(String)(list.getItemAtPosition(position));
                        Log.e("Error", "user login successfully"+animalNameList[position]);
                        txtSelectName.setText(animalNameList[position]);
                        dialog.cancel();
                    }
                });
        dialog.show();
    }
    public void webServiceCall(){
        arraylist.clear();
        for (int i = 0; i < animalNameList.length; i++) {
            AnimalNames animalNames = new AnimalNames(animalNameList[i]);
            // Binds all strings into an array
            arraylist.add(animalNames);
        }
        adapter = new ListViewAdapter(this, arraylist);
        list.setAdapter(adapter);
    }
}
