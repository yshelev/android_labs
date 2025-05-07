package com.example.second_lab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.activityViewModels

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class TaskListFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    private val viewModel: MyVM by activityViewModels()
    private var showOnlyMyActivities = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            showOnlyMyActivities = it.getBoolean(ARG_SHOW_ONLY_MY, true)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_task_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler)
        val adapter = RVAdapter()
        recyclerView.adapter = adapter

        viewModel.allActivities.observe(viewLifecycleOwner) { activities ->
            val filteredActivities = if (showOnlyMyActivities) {
                activities.filter { it.user == "me" }
            } else {
                emptyList()
            }
            adapter.updateData(filteredActivities)
        }

        recyclerView.addItemDecoration(
            DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        )

        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        private const val ARG_SHOW_ONLY_MY = "show_only_my"

        @JvmStatic
        fun newInstance(showOnlyMyActivities: Boolean): TaskListFragment {
            return TaskListFragment().apply {
                arguments = Bundle().apply {
                    putBoolean(ARG_SHOW_ONLY_MY, showOnlyMyActivities)
                }
            }
        }
    }
}