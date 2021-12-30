package org.example.todolist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import org.example.todolist.model.TodoModel
import org.example.todolist.repository.TodoRepository

class TodoViewModel(application: Application) : AndroidViewModel(application) {
    private val mTodoRepository: TodoRepository
    private var mTodoItems: LiveData<List<TodoModel>>
    private var mTodoItemsMiddle: LiveData<List<TodoModel>>
    private var mTodoItemsAfter: LiveData<List<TodoModel>>

    init {
        mTodoRepository = TodoRepository(application)
        mTodoItems = mTodoRepository.getTodoBeforeList()
        mTodoItemsMiddle = mTodoRepository.getTodoMiddleList()
        mTodoItemsAfter = mTodoRepository.getTodoAfterList()

    }

    fun insertTodo(todoModel: TodoModel) {
        mTodoRepository.insertTodo(todoModel)
    }

    fun getTodoBeforeList(): LiveData<List<TodoModel>> {
        return mTodoItems
    }

    fun getTodoMiddleList(): LiveData<List<TodoModel>>{
        return mTodoItemsMiddle
    }

    fun getTodoAfterList(): LiveData<List<TodoModel>>{
        return mTodoItemsAfter
    }

    fun updateTodoBeforeToMiddle(todoModelID: Long?) {
        mTodoRepository.updateTodoBeforeToMiddle(todoModelID)
    }

    fun updateTodoMiddleToAfter(todoModelID: Long?){
        mTodoRepository.updateTodoMiddleToAfter(todoModelID)
    }

}