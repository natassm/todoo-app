package com.example.todoo_app.support

import android.app.Activity
import android.content.Intent
import com.example.todoo_app.screen.*

object TDRouter {

    fun onGoToDashboard(activity: Activity): Intent = Intent(activity, TDDashboardActivity::class.java)

    fun onGoToAddTasks(activity: Activity): Intent = Intent(activity, TDAddTasksActivity::class.java)

    fun onGoToListTasks(activity: Activity): Intent = Intent(activity, TDListTasksActivity::class.java)

    fun onGoToListNotes(activity: Activity): Intent = Intent(activity, TDListNotesActivity::class.java)

    fun onGoToAddNotes(activity: Activity): Intent = Intent(activity, TDAddNotesActivity::class.java)

    fun onGoToAlarm(activity: Activity): Intent = Intent(activity, TDAlarmActivity::class.java)
}