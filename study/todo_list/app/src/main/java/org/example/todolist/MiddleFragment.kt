package org.example.todolist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import org.example.todolist.adapter.TodoAdapter

class MiddleFragment : Fragment(){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textList = arrayListOf(
            TodoAdapter.Text("음냠냠"),
            TodoAdapter.Text("으아아앙"),
            TodoAdapter.Text("진행중")
        )
        Log.d("dmdkdk", "1234")
//        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview_middle)
//        recyclerView?.adapter= TodoAdapter(textList) 왜 주석처리 했는데도 여기가 문제일까요
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_middle, container, false)
    }
}