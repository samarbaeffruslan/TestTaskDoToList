package com.example.tasklist.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.findNavController
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.core.db.entites.TaskEntity
import com.example.core.navigation.TaskListNavigator
import com.example.tasklist.R
import com.example.tasklist.adapters.TaskAdapter
import com.example.tasklist.databinding.FragmentTaskBinding
import com.example.tasklist.di.TaskFragmentComponent
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class TaskFragment: Fragment(R.layout.fragment_task), TaskAdapter.OnItemClickListener {

    private var _binding: FragmentTaskBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var listNavigator: TaskListNavigator

    lateinit var adapter: TaskAdapter


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by activityViewModels<TaskFragmentViewModel> { viewModelFactory }



    override fun onAttach(context: Context) {
        TaskFragmentComponent.injectFragment(this)
        super.onAttach(context)
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTaskBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        initItemTouchHelper(view)
        observeListTask()
        navigationFab()


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRecyclerView() {
        adapter = TaskAdapter(this)
        binding.recycler.apply {
            this.adapter = this@TaskFragment.adapter
            layoutManager = LinearLayoutManager(activity)

        }
    }


    private fun initItemTouchHelper(view: View){
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val task = adapter.currentList[viewHolder.adapterPosition]
                viewModel.deleteTask(task)
                Snackbar.make(view, "Task was deleted", Snackbar.LENGTH_SHORT).apply {
                    setAction("UNDO") {
                        viewModel.savedItemInTask(task)
                    }
                }.show()
            }
        }).attachToRecyclerView(binding.recycler)
    }



    override fun onCheckBoxClick(taskEntity: TaskEntity, isChecked: Boolean) {
        viewModel.onTaskCheckedChanged(taskEntity, isChecked)
    }

    private fun observeListTask(){
        viewModel.getListObserve().observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

    private fun navigationFab(){
        val navController = findNavController()
        binding.fab.setOnClickListener {
            listNavigator.navigateToAddItemTask(navController)
        }
    }

}