package com.example.lalit.lalitdev.TwitterLoginDemo.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.lalit.lalitdev.R;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

/**
 * Created by Admin on 1/8/2018.
 * url - https://dev.twitter.com/twitterkit/android/installation
 * url - http://www.theappguruz.com/blog/android-twitter-integration-tutorial
 * url - https://www.mytrendin.com/login-using-twitter-android-application-tutorial/
 *
 * url - https://www.androidtutorialpoint.com/material-design/twitter-login-android-tutorial-using-fabric-twitter-login-kit/
 *
 * 1.adding fabric from the setting and browser repositors
 * 2.click on fabric and fill login details
 * 3.select the project and click in next
 * 4.open all kits and click on twitter kit
 *
 *
 * inert the valis call back url
 *  http://www.thiswebsitedoesnotexistyet.de
 */

public class LoginWithTwitterDemoActivity extends Activity {
    TwitterLoginButton twitterLoginButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Twitter.initialize(this);
        setContentView(R.layout.activity_twitter_login_demo_layout);
        //Get User records from SQLite DB

        TwitterConfig config = new TwitterConfig.Builder(this)
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig("CONSUMER_KEY", "CONSUMER_SECRET"))
                .debug(true)
                .build();
        Twitter.initialize(config);
        initViews();
    }
    public  void initViews(){
        twitterLoginButton = (TwitterLoginButton) findViewById(R.id.login_button);
        twitterLoginButton.setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                // Do something with result, which provides a TwitterSession for making API calls
            }
            @Override
            public void failure(TwitterException exception) {
                // Do something on failure
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result to the login button.
        twitterLoginButton.onActivityResult(requestCode, resultCode, data);
    }

}