package com.example.tasks_mvvm.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.tasks_mvvm.R
import com.example.tasks_mvvm.databinding.ItemTaskBinding
import com.example.tasks_mvvm.dto.TaskDto
import com.example.tasks_mvvm.ui.listener.ITaskClickListener

class TaskAdapter (val clickListener : ITaskClickListener): RecyclerView.Adapter<TaskAdapter.ViewHolder>(){

    private var dataset: List<TaskDto> = emptyList()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding: ItemTaskBinding = ItemTaskBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val taskDto = dataset[position]
        val colorId = if(taskDto.isCompleted){
            R.color.green
        } else {
            R.color.grey
        }

        val color = ContextCompat.getColor(holder.binding.root.context, colorId)

        holder.binding.textDescription.text = taskDto.description
        holder.binding.imageDone.setColorFilter(color)

        holder.binding.imageDone.setOnClickListener{
            clickListener.clickDone(position)
        }

        holder.binding.imageDelete.setOnClickListener{
            clickListener.clickDelete(position)
        }
    }

    fun submitDataset(data: List<TaskDto>){
        dataset = data
    }

}