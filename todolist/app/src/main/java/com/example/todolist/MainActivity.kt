package com.example.todolist

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)

        val mainWork = ArrayList<Work>()
        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, AddWork::class.java)
            startActivityForResult(intent, 100)

            var getWork = intent.getStringExtra("work")
            var getPeriod = intent.getStringExtra("date")

            mainWork.add(Work(getWork, getPeriod))

            val adapter=Adapter(mainWork)

            recyclerView.adapter = adapter
        }

        /*Toast.makeText(this, getWork,Toast.LENGTH_LONG).show()
        if(intent.hasExtra("work")){



        } else{
            Toast.makeText(this,"전달 받은 정보가 없습니다.", Toast.LENGTH_SHORT).show()
        }*/






    }

}
