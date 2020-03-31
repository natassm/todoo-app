package com.example.todoo_app.support

import android.app.Activity
import android.content.Intent
import com.example.todoo_app.screen.TDAddTasksActivity
import com.example.todoo_app.screen.TDDashboardActivity
import com.example.todoo_app.screen.TDListTasksActivity

object TDRouter {

    fun onGoToDashboard(activity: Activity): Intent = Intent(activity, TDDashboardActivity::class.java)

    fun onGoToAddTasks(activity: Activity): Intent = Intent(activity, TDAddTasksActivity::class.java)

    fun onGoToListTasks(activity: Activity): Intent = Intent(activity, TDListTasksActivity::class.java)
}