package org.example.todolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import org.example.todolist.adapter.TodoAdapter
import org.example.todolist.base.BaseFragment

class BeforeFragment : BaseFragment(){
    override val layoutResourceId = R.layout.fragment_before

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textList = arrayListOf(
            TodoAdapter.Text("물건사기"),
            TodoAdapter.Text("청소하기"),
            TodoAdapter.Text("뭐할까")
        )
        val recyclerView = getView()?.findViewById<RecyclerView>(R.id.recyclerview_before)
        recyclerView?.adapter=TodoAdapter(textList)
    }
}