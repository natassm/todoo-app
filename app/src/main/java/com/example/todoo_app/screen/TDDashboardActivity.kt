package com.example.todoo_app.screen

import android.view.animation.AnimationUtils
import com.example.todoo_app.support.base.TDBaseActivity
import com.example.todoo_app.R
import kotlinx.android.synthetic.main.activity_dashboard.*

class TDDashboardActivity : TDBaseActivity(){

    override fun getContentViewId(): Int = R.layout.activity_dashboard

    override fun initiateDefaultValue() {
        super.initiateDefaultValue()

        val animation = AnimationUtils.loadAnimation(this, R.anim.splash_animation)
        dashboardIntroTextView.startAnimation(animation)
    }
}
