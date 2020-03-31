package com.example.todoo_app.support.base

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.todoo_app.R

abstract class TDBaseActivity : AppCompatActivity(), View.OnClickListener{

    companion object {
        init {
            AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentViewId())

        hideActionBar()

        initiateViewModels()
        initiateDefaultValue()

        Handler()
    }

    override fun onClick(view: View) {
        setOnClickAction(view.id)
    }

    protected open fun setOnClickAction(id: Int) {
        when (id) {
            R.id.toolbarBackImageView -> onBackPressed()
        }
    }

    protected fun hideActionBar() {
        val actionBar = supportActionBar
        actionBar?.hide()
    }

    protected open fun initiateDefaultValue() {

    }

    protected open fun initiateViewModels() {

    }

    protected fun buildOnClickListener(vararg views: View) {
        for (view in views) {
            view.setOnClickListener(this)
        }
    }

    protected abstract fun getContentViewId(): Int
}