package com.example.todolist

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, AddWork::class.java)
            startActivityForResult(intent, 100)
        }

        var getWork = intent.getStringExtra("work")
//        Toast.makeText(this, getWork,Toast.LENGTH_LONG).show()
        if(intent.hasExtra("work")){
            var getWork = intent.getStringExtra("work")
            Toast.makeText(this,getWork,Toast.LENGTH_LONG).show()
        } else{
            Toast.makeText(this,"전달 받은게 없당 ㅎㅎ...", Toast.LENGTH_SHORT).show()
        }
    }

}
