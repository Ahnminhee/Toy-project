package com.example.ticktalk;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class LoginActivity extends AppCompatActivity {

    private Button login;
    private Button signup;
    private FirebaseRemoteConfig mFirebaseRemoteConfig;
    private final static String TAG = "MyTag";

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();

        String main_background = mFirebaseRemoteConfig.getString("main_background");
        getWindow().setStatusBarColor(Color.parseColor(main_background));

        login = findViewById(R.id.loginactivity_btn_login);
        signup = findViewById(R.id.loginactivity_btn_signup);

        login.setBackgroundColor(Color.parseColor(main_background));
        signup.setBackgroundColor(Color.parseColor(main_background));

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                Log.d(TAG,"signupActivity 호출");
                startActivity(intent);
            }
        });

    }
}
