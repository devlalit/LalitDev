package com.example.lalit.lalitdev.FacebookIntegrationDemo.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import com.example.lalit.lalitdev.R;
import com.example.lalit.lalitdev.SplashScreen.SplashScreen1;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import org.json.JSONObject;

/**
 * Created by Admin on 1/4/2018.
 * URL IS - https://www.studytutorial.in/android-facebook-integration-and-login-tutorial
 * 1-DWON LOAF OPEN SSL
 * 2- CRERATE THE FOLDER ON C DRIVE AND PASTE THE FILE ONIT
 * 3- face book developer on site creat new app and fill all information and get the key and generete the hash kry and put and implement the code on Activity
 * Facebook Conconsle
 * 1.login with facebook account.
 * 2.in face book console ,click on create new app.
 * 3.intert app name and create the app id
 * 4.select product ..click on android.
 * 5.insert the pacakge name and activity name where when we login with facebook then open this page.
 * 6.the put the release key
 *      keytool -exportcert -alias YOUR_RELEASE_KEY_ALIAS -keystore YOUR_RELEASE_KEY_PATH | openssl sha1 -binary | openssl base64
 *  7.in xml crete the facebook button
 *  8.in activity Callback manager
 *  9.intilize the LoginButton
 *  10. loginButton.registerCallback
 *  11.protected void onActivityResult
 *  12.protected void getUserDetails
 *  13.if we get access token then login with facebook and redirethe the face on ManinActivity
 *
 *
 */

public class FaceBookDemoActivity extends Activity {
    CallbackManager callbackManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_login_layout);
        //Get User records from SQLite DB
        callbackManager = CallbackManager.Factory.create();
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                getUserDetails(loginResult);
            }
            @Override
            public void onCancel() {
                // App code
            }
            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });
        initViews();
    }
    public  void initViews(){
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
    protected void getUserDetails(LoginResult loginResult) {
        GraphRequest data_request = GraphRequest.newMeRequest(
                loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(
                            JSONObject json_object,
                            GraphResponse response) {
                        try {
                            // Application code
                            String email = response.getJSONObject().getString("email");
                            Log.d("email id","the facebooklogin email id"+email);
                        }catch(Exception e){
                            e.printStackTrace();;
                        }
                        Intent intent = new Intent(FaceBookDemoActivity.this, SplashScreen1.class);
                        intent.putExtra("userProfile", json_object.toString());
                        startActivity(intent);
                    }

                });
        Bundle permission_param = new Bundle();
        permission_param.putString("fields", "id,name,email,picture.width(120).height(120)");
        data_request.setParameters(permission_param);
        data_request.executeAsync();

    }
}
