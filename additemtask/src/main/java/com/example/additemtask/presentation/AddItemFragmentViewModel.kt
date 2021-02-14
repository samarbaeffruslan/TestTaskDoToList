package com.example.additemtask.presentation

import androidx.lifecycle.ViewModel
import com.example.additemtask.data.AddItemRepository
import com.example.core.db.entites.TaskEntity
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddItemFragmentViewModel @Inject constructor(
    private val repository: AddItemRepository
): ViewModel() {

    fun savedItemInTask(taskEntity: TaskEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.savedItemTask(taskEntity)
        }
    }

}