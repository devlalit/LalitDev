package com.example.lalit.lalitdev.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lalit.lalitdev.MainActivity;
import com.example.lalit.lalitdev.R;
import com.example.lalit.lalitdev.RecyclerViewDemo.RecyclerViewActivity;

/**
 * Created by lalit on 9/15/2017.
 */

public class LoginActivity  extends AppCompatActivity {
    EditText edtEmail,edtPassword;
    Button btnlogin;
    @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.loginactivity1);
        initView();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void initView(){
        edtEmail=(EditText)findViewById(R.id.edt_email);
        edtPassword=(EditText)findViewById(R.id.edt_password);
        btnlogin=(Button)findViewById(R.id.btn_login);
    }
}
