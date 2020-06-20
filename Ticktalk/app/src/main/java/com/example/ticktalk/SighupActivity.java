package com.example.ticktalk;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.ticktalk.model.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.net.URI;

public class SighupActivity extends AppCompatActivity {

    private static final int PICK_FROM_ALBUM = 10;
    EditText email;
    EditText name;
    EditText password;
    Button btnSignup;
    ImageView proflie;
    Uri imageUri;


    private final static String TAG = "MyTag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        proflie = findViewById(R.id.signupactivity_ImageView_profile);
        proflie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                startActivityForResult(intent,PICK_FROM_ALBUM);
            }
        });

        email= findViewById(R.id.signupactivity_edittext_email);
        name= findViewById(R.id.signupactivity_edittext_name);
        password= findViewById(R.id.signupactivity_edittext_password);
        btnSignup= findViewById(R.id.signupactivity_Btn_signup);

        final String getEmail = email.getText().toString();
        final String getName = name.getText().toString();
        final String getPassword = password.getText().toString();

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getEmail == null || getName == null || getPassword == null){
                    return ;
                }else {
                    Toast.makeText(getApplicationContext(), "버튼이 반응은 해!", Toast.LENGTH_SHORT).show();

                    FirebaseAuth.getInstance()
                            .createUserWithEmailAndPassword(getEmail, getPassword)
                            .addOnCompleteListener(SighupActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    String uid = task.getResult().getUser().getUid();
                                    FirebaseStorage.getInstance().getReference().child("userImages").child(uid)
                                            .putFile(imageUri).addOnCanceledListener();

                                    UserModel userModel = new UserModel();
                                    userModel.userName = name.getText().toString();

                                    FirebaseDatabase.getInstance().getReference().child("users").child(uid).setValue(userModel);


                                }
                            });

                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_FROM_ALBUM && requestCode == RESULT_OK) {
            proflie.setImageURI(data.getData());
            imageUri = data.getData();
        }
    }
}
