package com.example.lalit.lalitdev.CustomRecycleViewDemo;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lalit.lalitdev.Fragment.InvigationFragment;
import com.example.lalit.lalitdev.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by lalit on 9/27/2017.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<AndroidVersion> android;
    private Context context;

    public DataAdapter(Context context, ArrayList<AndroidVersion> android) {
        this.android = android;
        this.context = context;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final DataAdapter.ViewHolder viewHolder, final int i) {

        viewHolder.tv_android.setText(android.get(i).getAndroid_version_name());
        Picasso.with(context).load(android.get(i).getAndroid_image_url()).resize(240, 120).into(viewHolder.img_android);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("the positon on grid view is that ========="+i);

                Fragment fragment = new InvigationFragment();
                ((FragmentActivity)context).getFragmentManager().beginTransaction()
                        .replace(R.id.content, fragment)
                        .addToBackStack(null)
                        .commit();

            }
        });

    }
    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_android;
        private ImageView img_android;
        public ViewHolder(View view) {
            super(view);
            tv_android = (TextView)view.findViewById(R.id.tv_android);
            img_android = (ImageView) view.findViewById(R.id.img_android);
        }
    }

}
