package com.example.dailymoney

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val item: ArrayList<String>): RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_home, parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        holder.category.text = item[position]
       /* holder.price.text = item[position]*/
    }

    class ViewHolder(val textView: View): RecyclerView.ViewHolder(textView) {
        var category: TextView = itemView.findViewById(R.id.Category_text)
        /*var price: TextView = itemView.findViewById(R.id.Price_text)*/
    }

}