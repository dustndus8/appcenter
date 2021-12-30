package org.example.todolist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.example.todolist.adapter.TodoAdapter
import org.example.todolist.base.BaseFragment
import org.example.todolist.model.TodoModel
import org.example.todolist.viewmodel.TodoViewModel

class MiddleFragment : Fragment() {
    //override val layoutResourceId = R.layout.fragment_middle
    private lateinit var mTodoViewModel: TodoViewModel
    private lateinit var mTodoAdapter: TodoAdapter
    private val mTodoItems: ArrayList<TodoModel> = ArrayList()
    private lateinit var imageButtonAdd: ImageButton
    private lateinit var imageButtonRectangle: ImageButton
    private lateinit var todoText: String
    private lateinit var editText: EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview_middle)
        //recyclerView?.adapter= TodoAdapter(textList,1)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var root = inflater.inflate(R.layout.fragment_middle, container, false)
        var recyclerView = root.findViewById<RecyclerView>(R.id.recyclerview_middle)
        initRecyclerView(recyclerView)
        initViewModel()

        return root
    }

    private fun initViewModel() {
        mTodoViewModel =
            ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
                .create(
                    TodoViewModel::class.java
                )
        mTodoViewModel.getTodoMiddleList().observe(viewLifecycleOwner, Observer {
            mTodoAdapter.setTodoItems(it)
        })
    }

    private fun initRecyclerView(rcv: RecyclerView) {
        mTodoAdapter = TodoAdapter(1)
        rcv.run {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = mTodoAdapter
        }
    }
}