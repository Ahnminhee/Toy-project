package com.example.todolist

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import com.google.android.material.datepicker.MaterialDatePicker.Builder.datePicker
import kotlinx.android.synthetic.main.activity_add_work.*
import java.util.*

class AddWork : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_work)

        var MyWork = "null"
        val datePicker = findViewById<DatePicker>(R.id.dataPicker)
        val today = Calendar.getInstance()

        var mYear: Int
        var mMonth: Int
        var mDay: Int

        datePicker.init(
            today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)
        ) { view, year, month, day ->
            Toast.makeText(applicationContext, year + "년" + month + "월" + day +"일", Toast.LENGTH_SHORT).show();

            mYear = year
            mMonth = month
            mDay = day
        }

        MyWork = toDo.toString()
        toDo.setText(" ")

        save.setOnClickListener {
            if(MyWork != "null") {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("work", MyWork)
                startActivity(intent)
            }

            Toast.makeText(this,getyear,Toast.LENGTH_LONG).show()
        }


        //Intent 문제 양쪽에서 서로서로 호출,,.,..!! ...

    }
}