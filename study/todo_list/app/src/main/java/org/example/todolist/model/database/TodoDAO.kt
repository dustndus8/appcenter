package org.example.todolist.model.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import org.example.todolist.model.TodoModel

@Dao
interface TodoDAO {
    @Query("SELECT * from Todo where status = 'BEFORE'")
    fun getTodoBeforeList(): LiveData<List<TodoModel>>

    @Insert
    fun insertTodo(todoModel: TodoModel)

    @Query("SELECT * from Todo where status = 'MIDDLE'")
    fun getTodoMiddleList(): LiveData<List<TodoModel>>

    @Query("UPDATE Todo SET status = 'MIDDLE' WHERE status = 'BEFORE' and id = :todoModelID")
    fun updateTodoBeforeToMiddle(todoModelID: Long?)

}