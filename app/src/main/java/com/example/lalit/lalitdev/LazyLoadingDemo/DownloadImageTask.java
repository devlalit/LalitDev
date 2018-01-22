package com.example.lalit.lalitdev.LazyLoadingDemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import com.example.lalit.lalitdev.LazyLoadingDemo.Modle.PbAndImage;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import java.io.IOException;
import java.io.InputStream;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by lalit on 11/2/2017.
 */

public class DownloadImageTask extends AsyncTask<PbAndImage, Void, Bitmap> {

    ImageView imageView = null;
   // ImageView pb = null;
    GifImageView pb = null;
    Context context;

    protected Bitmap doInBackground(PbAndImage... pb_and_images) {
        this.imageView = (ImageView)pb_and_images[0].getImg();
        this.pb = (GifImageView)pb_and_images[0].getPb();
        return getBitmapDownloaded((String) imageView.getTag());
    }
    protected void onPostExecute(Bitmap result) {
        System.out.println("Downloaded " + imageView.getId());
        imageView.setVisibility(View.VISIBLE);
        pb.setVisibility(View.GONE);  // hide the progressbar after downloading the image.
        imageView.setImageBitmap(result); //set the bitmap to the imageview.
    }
    /** This function downloads the image and returns the Bitmap **/
    private Bitmap getBitmapDownloaded(String url) {
       /* System.out.println("String URL " + url);
        Bitmap bitmap = null;
    try {

            bitmap = BitmapFactory.decodeStream((InputStream) new URL(url).getContent());
            bitmap = getResizedBitmap(bitmap, 50, 50);
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        Bitmap img = null;
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);
        HttpResponse response;
        try {
            response = (HttpResponse)client.execute(request);
            HttpEntity entity = response.getEntity();
            BufferedHttpEntity bufferedEntity = new BufferedHttpEntity(entity);
            InputStream inputStream = bufferedEntity.getContent();
            img = BitmapFactory.decodeStream(inputStream);
            img = getResizedBitmap(img, 250, 500);
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return img;
      //  return bitmap;
    }
    /** decodes image and scales it to reduce memory consumption **/
    public Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth){
        int width =bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // CREATE A MATRIX FOR THE MANIPULATION
        Matrix matrix = new Matrix();
        // RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight);
        // RECREATE THE NEW BITMAP
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
        return resizedBitmap;
    }
}
