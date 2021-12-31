package org.example.todolist.repository

import android.app.Application
import androidx.lifecycle.LiveData
import org.example.todolist.model.TodoModel
import org.example.todolist.model.database.TodoDAO
import org.example.todolist.model.database.TodoDatabase

class TodoRepository(application: Application) {
    private var mTodoDatabase: TodoDatabase
    private var mTodoDAO: TodoDAO
    private var mTodoItems: LiveData<List<TodoModel>>
    private var mTodoItemsMiddle: LiveData<List<TodoModel>>
    private var mTodoItemsAfter: LiveData<List<TodoModel>>


    init {
        mTodoDatabase = TodoDatabase.getInstance(application)
        mTodoDAO = mTodoDatabase.todoDao()
        mTodoItems = mTodoDAO.getTodoBeforeList()
        mTodoItemsMiddle = mTodoDAO.getTodoMiddleList()
        mTodoItemsAfter = mTodoDAO.getTodoAfterList()
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


    fun insertTodo(todoModel: TodoModel) {
        Thread(Runnable {
            mTodoDAO.insertTodo(todoModel)
        }).start()
    }

    fun deleteTodo(todoModel: TodoModel){
        Thread(Runnable {
            mTodoDAO.deleteTodo(todoModel)
        }).start()
    }

    fun updateTodoBeforeToMiddle(todoModelID: Long?){
        Thread(Runnable {
            mTodoDAO.updateTodoBeforeToMiddle(todoModelID)
        }).start()
    }

    fun updateTodoMiddleToAfter(todoModelID: Long?){
        Thread(Runnable {
            mTodoDAO.updateTodoMiddleToAfter(todoModelID)
        }).start()
    }

}