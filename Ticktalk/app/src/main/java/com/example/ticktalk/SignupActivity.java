package com.example.ticktalk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    private EditText email;
    private EditText name;
    private EditText password;
    private Button btnSignup;

    private final static String TAG = "MyTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Log.d(TAG,"호출됨");

        email.findViewById(R.id.signupactivity_edittext_email);
        name.findViewById(R.id.signupactivity_edittext_name);
        password.findViewById(R.id.signupactivity_edittext_password);
        btnSignup.findViewById(R.id.signupactivity_Btn_signup);

        final String getEmail = email.getText().toString();
        final String getName = name.getText().toString();
        final String getPassword = password.getText().toString();

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getEmail == null || getName == null || getPassword == null){
                    return ;
                }else {

                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(getEmail, getPassword)
                            .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                }
                            });
                }
            }
        });
    }
}
