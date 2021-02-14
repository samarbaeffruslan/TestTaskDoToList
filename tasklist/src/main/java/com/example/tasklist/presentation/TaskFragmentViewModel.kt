package com.example.tasklist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.db.entites.TaskEntity
import com.example.tasklist.data.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class TaskFragmentViewModel @Inject constructor(
    private val repository: TaskRepository
) : ViewModel() {


    fun getListObserve() = repository.getTasks()

    fun deleteTask(taskEntity: TaskEntity) = viewModelScope.launch {
        repository.deleteTask(taskEntity)
    }

    fun onTaskCheckedChanged(taskEntity: TaskEntity, isChecked: Boolean) = viewModelScope.launch {
        repository.updateTask(taskEntity.copy(completed = isChecked))
    }

    fun savedItemInTask(taskEntity: TaskEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.savedItemTask(taskEntity)
        }
    }



}