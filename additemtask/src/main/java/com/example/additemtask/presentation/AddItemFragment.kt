package com.example.additemtask.presentation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.activityViewModels
import android.view.LayoutInflater
import androidx.navigation.fragment.findNavController
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.additemtask.R
import com.example.additemtask.databinding.FragmentAddItemBinding
import com.example.additemtask.di.AddItemComponent
import com.example.core.db.entites.TaskEntity
import com.example.core.navigation.AddItemTaskNavigator
import javax.inject.Inject

class AddItemFragment: Fragment(R.layout.fragment_add_item) {

    private var _binding: FragmentAddItemBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by activityViewModels<AddItemFragmentViewModel> { viewModelFactory }


    @Inject
    lateinit var navigator: AddItemTaskNavigator




    override fun onAttach(context: Context) {
        AddItemComponent.injectFragment(this)
        super.onAttach(context)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddItemBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        clickFabSaveTask()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun clickFabSaveTask(){
        binding.fabSaveTask.setOnClickListener {
            val content = binding.editTextTaskName.text.toString()
            val entity = TaskEntity(
                name = content
            )
            if(content.isNotEmpty()){
                viewModel.savedItemInTask(entity)
            }
            val navControl = findNavController()
            navigator.navigateToListTask(navControl)

        }
    }
}