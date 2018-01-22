package com.example.lalit.lalitdev.GooglePlusDemo.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.lalit.lalitdev.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import static android.content.ContentValues.TAG;

/**
 * Created by Admin on 1/9/2018.
 * url - https://www.androidhive.info/2014/02/android-login-with-google-plus-account-1/
 * 1.Generating Google-Services.json
 * 2.create the SHA1 KEY
 * 3.goto google service
 *    1.inert app name
 *    2.inert the app package name
 *    3.click in cingiguration to the (select google service)
 *    4.inert the SHA1 key
 *    5.click on enavble to google sign in
 *    6.click on genrerate the congigaur file
 *    7.click on download the google service.json file
 *    8.pun the this json file in out project on folder in app
 *    9.Add the dependency to your project-level build.gradle
 *      classpath 'com.google.gms:google-services:3.1.0'
 *    10.Add the plugin to your app-level build.gradle
 *      apply plugin: 'com.google.gms.google-services'
 *    11.Add the SignInButton in your application's layout
 *    12.Create the object of  GoogleSignInOptions and GoogleApiClient on create
 *    13.implement the method of signIn(), onActivityResult , handleSignInResult
 *
 */

public class GooglePlusDemoActivity extends AppCompatActivity implements View.OnClickListener ,GoogleApiClient.OnConnectionFailedListener{

    private static final int RC_SIGN_IN = 007;
    private GoogleApiClient mGoogleApiClient;


    private SignInButton btnSignIn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_plus_layout);
        //Get User records from SQLite DB
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();



        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        btnSignIn = (SignInButton) findViewById(R.id.sign_in_button);

        btnSignIn.setOnClickListener(this);
        initViews();
    }
    public  void initViews(){
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_button:
                signIn();
                break;

        }
    }
    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }
    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        // An unresolvable error has occurred and Google APIs (including Sign-In) will not
        // be available.
        Log.d(TAG, "onConnectionFailed:" + connectionResult);
    }
    private void handleSignInResult(GoogleSignInResult result) {
        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();

            Log.e(TAG, "display name: " + acct.getDisplayName());

            String personName = acct.getDisplayName();
            String personPhotoUrl = acct.getPhotoUrl().toString();
            String email = acct.getEmail();

            Log.e(TAG, "Name: " + personName + ", email: " + email
                    + ", Image: " + personPhotoUrl);


        } else {
            // Signed out, show unauthenticated UI.

        }
    }
  
}
