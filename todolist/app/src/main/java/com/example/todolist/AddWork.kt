package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_work.*

class AddWork : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_work)

        /*val datePicker = findViewById<DatePicker>(R.id.dataPicker)
        val today = Calendar.getInstance()
        var mYear: Int
        var mMonth: Int
        var mDay: Int */

        val work = toDo_text.toString()
        toDo_text.setText(" ")

        val date: String = date_text.toString()
        date_text.setText(" ")

        save_btn.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("work", work)
                intent.putExtra("date",date)
                startActivity(intent)

        }

        /*datePicker.init(
            today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)
        ) { view, year, month, day ->
            Toast.makeText(this," "+ year + "년" + month + "월" + day +"일", Toast.LENGTH_SHORT).show();

            mYear = year
            mMonth = month
            mDay = day
        }*/





    }
}