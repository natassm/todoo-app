package com.example.todoo_app.screen

import com.example.todoo_app.support.base.TDBaseActivity
import android.os.Handler
import android.view.animation.AnimationUtils
import com.example.todoo_app.support.TDRouter
import com.example.todoo_app.R
import kotlinx.android.synthetic.main.activity_splash.*

class TDSplashActivity: TDBaseActivity() {

    override fun getContentViewId(): Int = R.layout.activity_splash

    override fun initiateDefaultValue() {
        super.initiateDefaultValue()

        setSplashScreen()
    }

    private fun setSplashScreen() {
        Handler().postDelayed({
            startActivity(TDRouter.onGoToDashboard(this@TDSplashActivity))
            finish()
        }, 5000)

        val animation = AnimationUtils.loadAnimation(this, R.anim.splash_animation)
        laundreeLogoImageView.startAnimation(animation)
    }
}