package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class Adapter(val workList: ArrayList<Work>) : RecyclerView.Adapter<Adapter.ViewHolder>(){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val work: Work = workList[position]

        holder.textViewWork.text = work.work
        holder.textViewDate.text = work.date
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return workList.size
    }

    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val textViewWork = itemView.findViewById<TextView>(R.id.toDo_text)
        val textViewDate = itemView.findViewById<TextView>(R.id.date_text)

    }

}