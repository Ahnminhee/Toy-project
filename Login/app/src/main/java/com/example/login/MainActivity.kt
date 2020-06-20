package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email=editText_email.text?.toString()
        val name=editText_name.text?.toString()
        val password=editText_password.text?.toString()



        signUp_btn.setOnClickListener {
            val intent = Intent(this@MainActivity, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
