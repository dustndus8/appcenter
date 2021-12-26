package org.example.todolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import org.example.todolist.adapter.TodoAdapter
import org.example.todolist.base.BaseFragment

class AfterFragment : BaseFragment(){
    override val layoutResourceId = R.layout.fragment_after
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textList = arrayListOf(
            TodoAdapter.Text("룰루랄라"),
            TodoAdapter.Text("ㅋㅋㄹ"),
            TodoAdapter.Text("ㅎㅎㅎ")
        )
        val recyclerView = getView()?.findViewById<RecyclerView>(R.id.recyclerview_after)
        recyclerView?.adapter= TodoAdapter(textList)
    }
}