package com.example.todoo_app.support.adapter.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoo_app.R
import com.example.todoo_app.support.adapter.recyclerview.viewholder.TDTasksListViewHolder
import com.example.todoo_app.support.adapter.recyclerview.viewholder.TasksListEntity
import java.util.ArrayList

class TDTasksListAdapter(private val entity: List<TasksListEntity>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        TDTasksListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_holder_tasks,
                parent, false))

    override fun getItemCount(): Int = entity.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TDTasksListViewHolder) {
            holder.setUpModelUI(entity[position])
        }
    }
}