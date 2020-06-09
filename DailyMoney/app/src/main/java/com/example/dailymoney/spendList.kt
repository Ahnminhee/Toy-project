package com.example.dailymoney

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_spend_list.*

class spendList : Fragment() {

    var moneyList = arrayListOf<Money>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_spend_list, container, false)

        if (v is RecyclerView) {
            /*recyclerView.rootView.findViewById<RecyclerView>(R.id.recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)*/


        }

        addBtn.setOnClickListener {
            val intent = Intent(context, AddInfo::class.java)
            startActivity(intent)
        }

        return v
    }
}