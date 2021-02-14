package com.example.tasklist.adapters

import android.graphics.Paint
import android.text.Spannable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.core.db.entites.TaskEntity
import com.example.tasklist.R
import com.example.tasklist.databinding.ItemTaskBinding


class TaskAdapter(private val listener: OnItemClickListener): ListAdapter<TaskEntity, TaskAdapter.TaskViewHolder>(taskDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
       getItem(position)?.let {
           holder.bind(it)
           holder.checkBoxClick(it)

       }
    }


    companion object {
        val taskDiffUtil = object : DiffUtil.ItemCallback<TaskEntity>() {
            override fun areItemsTheSame(oldItem: TaskEntity, newItem: TaskEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TaskEntity, newItem: TaskEntity): Boolean {
                return oldItem == newItem
            }

        }

    }

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        private val binding = ItemTaskBinding.bind(itemView)

        fun checkBoxClick(taskEntity: TaskEntity){
            binding.checkbox.setOnClickListener {
                val position = adapterPosition
                if( position != RecyclerView.NO_POSITION){
                    val taskEntity = getItem(position)
                    listener.onCheckBoxClick(taskEntity, binding.checkbox.isChecked)
                }
            }
        }


        fun bind(taskEntity: TaskEntity){
            binding.taskText.text = taskEntity.name
            binding.checkbox.isChecked = taskEntity.completed
            binding.taskText.paint.isStrikeThruText = taskEntity.completed
        }



    }

    interface OnItemClickListener {
        fun onCheckBoxClick(taskEntity: TaskEntity, isChecked: Boolean)
    }


}