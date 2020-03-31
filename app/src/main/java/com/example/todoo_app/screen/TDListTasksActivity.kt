package com.example.todoo_app.screen

import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoo_app.R
import com.example.todoo_app.support.TDRouter
import com.example.todoo_app.support.adapter.recyclerview.TDTasksListAdapter
import com.example.todoo_app.support.adapter.recyclerview.viewholder.TasksListEntity
import com.example.todoo_app.support.base.TDBaseActivity
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_list_tasks.*

class TDListTasksActivity: TDBaseActivity() {

    private lateinit var tasksListAdapter: TDTasksListAdapter

    override fun getContentViewId(): Int = R.layout.activity_list_tasks

    override fun initiateDefaultValue() {
        super.initiateDefaultValue()

        setUpRecyclerView()

        buildOnClickListener(listTasksImageView, toolbarBackImageView)
    }

    override fun setOnClickAction(id: Int) {
        super.setOnClickAction(id)
        when (id) {
            R.id.listTasksImageView -> startActivity(TDRouter.onGoToAddTasks(this@TDListTasksActivity))
        }
    }

    private fun setUpRecyclerView() {
        val list = listOf(
            TasksListEntity("Urgent", "Kerjain Project", "Project UI/UX", "31/03/2020"),
            TasksListEntity("Urgent", "Kerjain Project", "Project UI/UX", "31/03/2020"),
            TasksListEntity("Urgent", "Kerjain Project", "Project UI/UX", "31/03/2020"),
            TasksListEntity("Urgent", "Kerjain Project", "Project UI/UX", "31/03/2020"),
            TasksListEntity("Urgent", "Kerjain Project", "Project UI/UX", "31/03/2020"),
            TasksListEntity("Urgent", "Kerjain Project", "Project UI/UX", "31/03/2020")
        )

        tasksListAdapter = TDTasksListAdapter(list)

        listTasksRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            itemAnimator = DefaultItemAnimator()
            adapter = tasksListAdapter
        }
    }
}