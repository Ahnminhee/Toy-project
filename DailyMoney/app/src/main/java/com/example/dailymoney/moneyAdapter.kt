package com.example.dailymoney

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(val moneyList: ArrayList<Money>): RecyclerView.Adapter<Adapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.money_item, parent,false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return moneyList.size
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        holder.category.text = item[position]
       /* holder.price.text = item[position]*/
    }

    class ViewHolder(val textView: View): RecyclerView.ViewHolder(textView) {
        val textViewWork = itemView.findViewById<TextView>(R.id.)
        val textViewDate = itemView.findViewById<TextView>(R.id.date_text)
    }

}