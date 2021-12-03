package org.example.retrofit2.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.example.retrofit2.R
import java.util.Collections.list

class ChattingAdapter(private val list: ArrayList<Message>) : RecyclerView.Adapter<ChattingAdapter.ExampleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)

        return ExampleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        holder.message?.text = list[position].message
    }

    override fun getItemCount(): Int = list.size

    inner class ExampleViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var message: TextView? = null
        init {
            message = view.findViewById(R.id.item_message)
        }
    }
    data class Message(val message: String)
}

