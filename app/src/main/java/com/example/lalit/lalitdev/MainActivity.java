package com.example.lalit.lalitdev;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.lalit.lalitdev.NavigationDrawer.NavigationAdapter.DrawerListAdapter;
import com.example.lalit.lalitdev.UploadImageFromGrallery.UploadImage;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends Activity {
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
//    private static ArrayList<DataModel> data;
    static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;
    private static int RESULT_LOAD_IMAGE = 1;
    Toolbar toolbar;
    public static int[] drawer_icons = {R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher};

    TextView tv_selected_navigation;
    ImageView imgvUploadImage,imgvProfileImage;
    ArrayList<String> navigation_items;
    private DrawerListAdapter drawerListAdapter;
    private ListView lv_drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        SetDrawer();
    }
    private void init() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);

       // tv_selected_navigation = (TextView)findViewById(R.id.tv_selected_navigation);
        navigation_items = new ArrayList<>();

     //adding menu items for naviations
        navigation_items.add("Call");
        navigation_items.add("Favorite");
        navigation_items.add("Search");

        lv_drawer = (ListView) findViewById(R.id.lv_drawer);
    //---------upload the image on image view----------
        imgvUploadImage=(ImageView)findViewById(R.id.imgv_upload_image);
        imgvProfileImage=(ImageView)findViewById(R.id.imgv_profile_image);
        imgvUploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
              //  uploadImageToAnotherClass();
            }
        });
    }
    public  void uploadImageToAnotherClass(){
        Bitmap receiveBitmap = null;
        UploadImage uploadImage=new UploadImage();
        receiveBitmap = uploadImage.scaleImage();
        imgvProfileImage.setImageBitmap(receiveBitmap);
    }
     //-----------------------------uoload image set in image view-----------------------
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            Bitmap bmp = null;
            try {
                bmp = getBitmapFromUri(selectedImage);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            imgvProfileImage.setImageBitmap(bmp);
        }
    }
    private Bitmap getBitmapFromUri(Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor =
                getContentResolver().openFileDescriptor(uri, "r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();
        return image;
    }
    private void SetDrawer() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));

        toggle.syncState();

        drawerListAdapter = new DrawerListAdapter(MainActivity.this, navigation_items, drawer_icons);
        lv_drawer.setAdapter(drawerListAdapter);

        lv_drawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(navigation_items.get(position).equalsIgnoreCase("Call")){
              //      tv_selected_navigation.setText("Selected Call");
                }else if(navigation_items.get(position).equalsIgnoreCase("Favorite")){
             //       tv_selected_navigation.setText("Selected Favorite");
                }else if(navigation_items.get(position).equalsIgnoreCase("Search")){
            //        tv_selected_navigation.setText("Selected Search");
                }
            }
        });
    }
}
