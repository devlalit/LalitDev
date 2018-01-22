package com.example.lalit.lalitdev.CustomSwapeRecyclerview.Adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lalit.lalitdev.R;

import java.util.ArrayList;

/**
 * Created by lalit on 11/27/2017.
 */

public class DataAdapter1 extends RecyclerView.Adapter<DataAdapter1.ViewHolder> {
    private ArrayList countries;

    public DataAdapter1(ArrayList countries) {
        this.countries = countries;
    }

    @Override
    public DataAdapter1.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(final DataAdapter1.ViewHolder viewHolder, int i) {

        viewHolder.tv_country.setText(countries.get(i).toString());
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public void addItem(String country) {
        countries.add(country);
        notifyItemInserted(countries.size());
    }

    public void removeItem(int position) {
        countries.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, countries.size());
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_country;
        public ViewHolder(View view) {
            super(view);
            tv_country = (TextView)view.findViewById(R.id.tv_country);
        }
    }
}