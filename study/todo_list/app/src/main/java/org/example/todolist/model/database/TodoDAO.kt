package org.example.todolist.model.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import org.example.todolist.model.TodoModel

@Dao
interface TodoDAO {
    @Query("SELECT * from Todo")
    fun getTodoList(): LiveData<List<TodoModel>>

    @Insert
    fun insertTodo(todoModel: TodoModel)
}