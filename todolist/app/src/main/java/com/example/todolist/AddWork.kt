package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_work.*

class AddWork : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_work)

        save_btn.setOnClickListener {
            val work= toDo_text.text?.toString()
            val date = date_text.text?.toString()

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("work", work)
            intent.putExtra("date",date)
            startActivity(intent)

        }
    }
}