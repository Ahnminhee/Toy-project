package com.example.dailymoney

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_spend_list.*

class spendList : Fragment() {

    var moneyList = arrayListOf<Money>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        recyclerView.layoutManager = LinearLayoutManager(context)


        return inflater.inflate(R.layout.fragment_spend_list, container, false)
    }
}