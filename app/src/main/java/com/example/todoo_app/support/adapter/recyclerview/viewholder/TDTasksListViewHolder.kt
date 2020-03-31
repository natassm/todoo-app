package com.example.todoo_app.support.adapter.recyclerview.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_holder_tasks.view.*

class TDTasksListViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private lateinit var entity: TasksListEntity

    fun setUpModelUI(entity: TasksListEntity) {
        this.entity = entity

        itemView.itemListTitleTextView.text = entity.title
        itemView.itemListDescTextView.text = entity.description
        itemView.itemListDateTextView.text = entity.date
        itemView.itemListPriorityTextView.text = entity.priority
    }
}

data class TasksListEntity(val priority: String, val title: String, val description: String, val date: String)