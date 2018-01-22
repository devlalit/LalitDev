package com.example.lalit.lalitdev.LazyLoadingDemo.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.lalit.lalitdev.CustomRecycleViewDemo.AndroidVersion;
import com.example.lalit.lalitdev.LazyLoadingDemo.DownloadImageTask;
import com.example.lalit.lalitdev.LazyLoadingDemo.Modle.LazyLoader;
import com.example.lalit.lalitdev.LazyLoadingDemo.Modle.PbAndImage;
import com.example.lalit.lalitdev.R;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;

/**
 * Created by lalit on 11/2/2017.
 */

public class LazyLoaderAdapter extends RecyclerView.Adapter<LazyLoaderAdapter.ViewHolder> {
private ArrayList<LazyLoader> android_versions;
private Context context;
    View view;
   public LazyLoaderAdapter(Context context, ArrayList<LazyLoader> android_versions) {
        this.context = context;
        this.android_versions = android_versions;

        }
      @Override
    public LazyLoaderAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
          Context context = viewGroup.getContext();
          LayoutInflater inflater = LayoutInflater.from(context);
         view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_lazyloading_layout, viewGroup, false);
          LazyLoaderAdapter.ViewHolder viewHolder = new LazyLoaderAdapter
                  .ViewHolder(view);
         return viewHolder;
        }

    @Override
    public void onBindViewHolder(final LazyLoaderAdapter.ViewHolder viewHolder, int i) {
    //    AndroidVersion selectedStockItemPOJO = android_versions.get(i);
      viewHolder.tv_android.setText(android_versions.get(i).getAndroid_version_name());
     //   Picasso.with(context).load(android_versions.get(i).getAndroid_image_url()).resize(120, 60).into(viewHolder.img_android);

      viewHolder.img_android.setTag(android_versions.get(i).getAndroid_image_url());
      viewHolder.img_android.setId(i);

    PbAndImage pb_and_image = new PbAndImage();
    pb_and_image.setImg(viewHolder.img_android);
    pb_and_image.setPb((viewHolder.gifImageView));

    new DownloadImageTask().execute(pb_and_image);
    //viewHolder.tv_android.setText(android_versions.get(i).getAndroid_version_name());
  }
  @Override
  public int getItemCount() {
        return android_versions.size();
        }

  public class ViewHolder extends RecyclerView.ViewHolder{
    TextView tv_android;
    ImageView img_android,ImageView;
    ProgressBar pb_android;
    GifImageView gifImageView;
    public ViewHolder(View view) {
        super(view);
        tv_android = (TextView)view.findViewById(R.id.tv_android);
        img_android =(ImageView)view.findViewById(R.id.img_android);
        gifImageView = (GifImageView)view.findViewById(R.id.progressBar2);
    }
  }
}
