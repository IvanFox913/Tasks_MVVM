package com.example.tasks_mvvm.ui.listener

interface ITaskClickListener {

    fun clickDone(position: Int)

    fun clickDelete(position: Int)

}