package com.example.dailymoney

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class moneyAdapter(val moneyList: ArrayList<Money>): RecyclerView.Adapter<moneyAdapter.ViewHolder>(){
    class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview) {
        val textViewCategory = itemView.findViewById<TextView>(R.id.Category_text)
        val textViewPrice = itemView.findViewById<TextView>(R.id.Price_text)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.money_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = moneyList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val money: Money = moneyList[position]

        holder.textViewCategory.text = money.category
        holder.textViewPrice.text = money.price
    }


}