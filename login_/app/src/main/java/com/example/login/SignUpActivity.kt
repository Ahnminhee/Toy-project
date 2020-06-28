package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    private var firebaseauth: FirebaseAuth? = null

    var email: String? = null
    var password: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        firebaseauth = FirebaseAuth.getInstance()

        email = sign_edit_email.text.toString()
        password = sign_edit_password.text.toString()

        Toast.makeText(this, "무사 접속", Toast.LENGTH_SHORT).show()

        signUp_btn.setOnClickListener {
            create()
        }

    }

    private fun create(){
        firebaseauth!!.createUserWithEmailAndPassword(
            sign_edit_email.text.toString(),
            sign_edit_password.text.toString()
        ).addOnCompleteListener(this) {
            if(it.isSuccessful) {
                val user=firebaseauth?.currentUser
                Toast.makeText(this,"success",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this,"failed",Toast.LENGTH_SHORT).show()
            }
        }
    }


    /*private fun createUserId() {
        firebaseauth!!.createUserWithEmailAndPassword(
            sign_edit_email.text.toString(),
            sign_edit_password.text.toString()
        ).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                val user = firebaseauth!!.currentUser
                (user)
                Toast.makeText(this, "성공했습니다", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "실패했습니다", Toast.LENGTH_SHORT).show()
            }
        }

    }*/
}