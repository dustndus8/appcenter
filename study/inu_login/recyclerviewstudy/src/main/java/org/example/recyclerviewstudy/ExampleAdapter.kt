package org.example.recyclerviewstudy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.Collections.list

class ExampleAdapter(private val list: List<ExampleMessage>) : RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>() {
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
}

data class ExampleMessage(val imageUrl: String, val message: String)