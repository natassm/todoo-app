package com.example.todoo_app.screen

import android.text.PrecomputedText
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.WindowManager
import com.example.todoo_app.R
import com.example.todoo_app.support.base.TDBaseActivity

class TDAddNotesActivity : TDBaseActivity() {

    private lateinit var params: WindowManager.LayoutParams

    override fun getContentViewId(): Int =
        R.layout.activity_add_notes

    override fun initiateDefaultValue() {
        super.initiateDefaultValue()

//        setUpWindow()
    }

    private fun setUpWindow() {
        val displayMetrics =  DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        val width = displayMetrics.widthPixels
        val height = displayMetrics.heightPixels

        window.setLayout(width*8, height*7)

        params = window.attributes
        params.gravity = Gravity.CENTER
        params.x = 0
        params.y = -100

        window.attributes = params
    }
}
