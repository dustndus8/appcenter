package org.example.todolist.adapter

import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.example.todolist.R
import org.example.todolist.model.TodoModel
import org.w3c.dom.Text
import java.util.*
import kotlin.collections.ArrayList

class TodoAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var todoItems: List<TodoModel> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recyclerview,parent,false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val todoModel = todoItems[position]
        val todoViewHolder = holder as TodoViewHolder
        todoViewHolder.bind(todoModel)
    }

    override fun getItemCount(): Int=todoItems.size

    inner class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view){

        val todo_text = itemView.findViewById<TextView>(R.id.todo_text)
        val imageButtonRectangle = itemView.findViewById<ImageButton>(R.id.imageButton_rectangle)
        fun bind(todoModel: TodoModel){
            todo_text?.text= todoModel.description
            val pos = adapterPosition
            if(pos!= RecyclerView.NO_POSITION)
            {
                imageButtonRectangle?.setOnClickListener {
                    listener?.onItemClick(itemView,todoModel,pos)
                }
            }
        }

        val todo_text_after = itemView.findViewById<TextView>(R.id.todo_text_after)
        val imageButtonDelete = itemView.findViewById<ImageButton>(R.id.imageButton_delete)

    }

    interface OnItemClickListener{
        fun onItemClick(v:View, data: TodoModel, pos : Int)
    }
    private var listener : OnItemClickListener? = null
    fun setOnItemClickListener(listener : OnItemClickListener) {
        this.listener = listener
    }

    /*fun setRecyclerView(position: Int?): Int {
        when (position) {
            1 -> return R.layout.item_recyclerview
            2 -> return R.layout.item_recyclerview_after
            else -> return R.layout.item_recyclerview
        }
    }*/

    fun setTodoItems(todoItems: List<TodoModel>){
        this.todoItems = todoItems
        notifyDataSetChanged()
    }
}