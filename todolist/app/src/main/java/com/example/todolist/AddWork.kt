package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_add_work.*
import java.lang.StringBuilder

class AddWork : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_work)
    }

    fun saveWork(view: View) {

        val work= toDo_text.text?.toString()
        val getYear : Int = datePicker.year
        val getMonth: Int = datePicker.month
        val getDay: Int = datePicker.dayOfMonth

        val temporary = StringBuffer()
        temporary.append(getYear).append(getMonth).append(getDay)

        val date: String = temporary.toString()

        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("work",work)
        intent.putExtra("date", date)

        startActivity(intent)
    }
}