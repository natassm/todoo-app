package com.example.todoo_app.screen

import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoo_app.R
import com.example.todoo_app.support.TDRouter
import com.example.todoo_app.support.adapter.recyclerview.TDTasksListAdapter
import com.example.todoo_app.support.adapter.recyclerview.viewholder.TasksListEntity
import com.example.todoo_app.support.base.TDBaseActivity
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_list_notes.*
import kotlinx.android.synthetic.main.activity_list_tasks.*
import kotlinx.android.synthetic.main.activity_list_tasks.tasksTextView
import kotlinx.android.synthetic.main.activity_list_tasks.toolbarBackImageView

class TDListTasksActivity: TDBaseActivity() {

    private lateinit var tasksListAdapter: TDTasksListAdapter

    override fun getContentViewId(): Int = R.layout.activity_list_tasks

    override fun initiateDefaultValue() {
        super.initiateDefaultValue()

        setUpRecyclerView()
        setUpAnimation()

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
            TasksListEntity("Urgent", "Project", "Add Proximity Sensor and Gyroscope Sensor", "31/03/2020"),
            TasksListEntity("Medium", "Eat", "Don't forget to eat and drink!", "01/04/2020"),
            TasksListEntity("Medium", "Learn Kotlin", "Learn about animation using Kotlin Language", "07/04/2020"),
            TasksListEntity("Urgent", "Project", "Add Proximity Sensor and Gyroscope Sensor", "31/03/2020"),
            TasksListEntity("Medium", "Eat", "Don't forget to eat and drink!", "01/04/2020"),
            TasksListEntity("Medium", "Learn Kotlin", "Learn about animation using Kotlin Language", "07/04/2020")
        )

        tasksListAdapter = TDTasksListAdapter(list)

        listTasksRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            itemAnimator = DefaultItemAnimator()
            adapter = tasksListAdapter
        }
    }

    private fun setUpAnimation() {
        val animation = AnimationUtils.loadAnimation(this, R.anim.slide_up)
        tasksTextView.startAnimation(animation)

        val animation2 = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
        listTasksImageView.startAnimation(animation2)

        val animation3 = AnimationUtils.loadAnimation(this, R.anim.move)
        listTasksRecyclerView.startAnimation(animation3)
    }
}