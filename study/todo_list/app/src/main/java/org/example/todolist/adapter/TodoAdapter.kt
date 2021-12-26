package org.example.todolist.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.example.todolist.R

class TodoAdapter(private val texts: ArrayList<Text>) : RecyclerView.Adapter<TodoAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recyclerview,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text?.text=texts[position].txt
        Log.i("v",position.toString())
    }

    override fun getItemCount(): Int=texts.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var text: TextView? =null
        init {
            text = view.findViewById(R.id.todo_text)
        }
    }
    data class Text(val txt: String)
}