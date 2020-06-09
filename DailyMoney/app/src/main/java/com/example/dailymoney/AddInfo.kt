package com.example.dailymoney

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_info.*

class AddInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_info)

        save_btn.setOnClickListener {
            val getDate = date.text?.toString()
            val getMoney = spendMoney.text?.toString()

            val intnet = Intent(this, spendList::class.java)
            intent.putExtra("date",getDate)
            intnet.putExtra("money", getMoney)
            startActivity(intent)

            Toast.makeText(this,"데이터를 보냈습니다",Toast.LENGTH_SHORT).show()
        }


    }
}