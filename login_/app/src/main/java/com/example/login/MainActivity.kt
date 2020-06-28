package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var firebaseauth: FirebaseAuth? = null

    private var email: String? = null
    private var password: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email = main_edit_email.text?.toString()
        password = main_edit_password.text?.toString()

        main_login_btn.setOnClickListener {
            loginEmail(email,password)
        }

        main_signUp_btn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loginEmail(email: String?, password: String?) {

        if (email != null) {
            if (password != null) {
                firebaseauth?.signInWithEmailAndPassword(email, password)
                    ?.addOnCompleteListener(this) {
                        if (it.isSuccessful) {
                            Toast.makeText(this,"로그인 성공",Toast.LENGTH_SHORT).show()

                        } else {
                            Toast.makeText(this, "회원가입 또는 재확인 해주세요.", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }
}



