package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val mainWork = ArrayList<Work>()

        val fab: View = findViewById(R.id.fab)

        fab.setOnClickListener {
            val intent = Intent(this@MainActivity, AddWork::class.java)
            startActivity(intent)
        }

        var getWork= intent.getStringExtra("work")
        var getPeriod= intent.getStringExtra("date")

        if(getWork == null || getPeriod == null) {
            println("")
        } else{
            mainWork.add(Work(getWork,getPeriod))

            val adapter=Adapter(mainWork)

            recyclerView.adapter = adapter

        }

    }

}
