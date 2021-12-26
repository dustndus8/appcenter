package org.example.todolist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import org.example.todolist.adapter.TodoAdapter
import org.example.todolist.base.BaseFragment

class MiddleFragment : BaseFragment(){
    override val layoutResourceId = R.layout.fragment_middle

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textList = arrayListOf(
            TodoAdapter.Text("음냠냠"),
            TodoAdapter.Text("으아아앙"),
            TodoAdapter.Text("진행중")
        )
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview_middle)
        recyclerView?.adapter= TodoAdapter(textList)
    }
}