package com.example.todoo_app.support

import android.app.Activity
import android.content.Intent
import com.example.todoo_app.screen.TDDashboardActivity

object TDRouter {

    fun onGoToDashboard(activity: Activity): Intent = Intent(activity, TDDashboardActivity::class.java)
}