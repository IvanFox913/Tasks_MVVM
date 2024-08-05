package com.example.tasks_mvvm.data.repository

import com.example.tasks_mvvm.data.dao.TaskDao
import com.example.tasks_mvvm.data.model.Task

class TaskRepository {

    private val dao = TaskDao

    fun findAll(): List<Task>{
        return dao.getAllTasks()
    }

    fun findBy(id: Long): Task{
        return dao.getTask(id)
    }

    fun insert(task: Task){
        dao.addTask(task)
    }

    fun delete(task: Task){
        dao.deleteTask(task)
    }
}