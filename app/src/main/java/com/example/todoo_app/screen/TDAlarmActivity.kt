package com.example.todoo_app.screen

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.view.animation.AnimationUtils
import com.example.todoo_app.R
import com.example.todoo_app.support.base.TDBaseActivity
import kotlinx.android.synthetic.main.activity_alarm.*
import kotlinx.android.synthetic.main.activity_alarm.toolbarBackImageView
import java.util.*

class TDAlarmActivity: TDBaseActivity() {

    override fun getContentViewId(): Int = R.layout.activity_alarm

    override fun initiateDefaultValue() {
        super.initiateDefaultValue()

        buildOnClickListener(setAlarmTimeTextView, setAlarmDateTextView, toolbarBackImageView)

        setUpAnimation()
    }

    override fun setOnClickAction(id: Int) {
        super.setOnClickAction(id)
        when (id) {
            R.id.setAlarmDateTextView -> setUpCalendar()
            R.id.setAlarmTimeTextView -> setClock()
        }
    }

    private fun setUpAnimation() {
        val animation = AnimationUtils.loadAnimation(this, R.anim.splash_animation)
        alarmTextView.startAnimation(animation)

        val animation2 = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
        alarmTimeTextView.startAnimation(animation2)
        alarmDateTextView.startAnimation(animation2)

        val animation3 = AnimationUtils.loadAnimation(this, R.anim.slide_up)
        setAlarmDateTextView.startAnimation(animation3)

        val animation4 = AnimationUtils.loadAnimation(this, R.anim.slide_down)
        setAlarmTimeTextView.startAnimation(animation4)
    }

    private fun setUpCalendar() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                alarmDateTextView.text = "$dayOfMonth / ${month+1} / $year"
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }

    private fun setClock() {
        val mTimePicker: TimePickerDialog
        val mCurrentTime = Calendar.getInstance()
        val hour = mCurrentTime.get(Calendar.HOUR_OF_DAY)
        val minute = mCurrentTime.get(Calendar.MINUTE)

        mTimePicker = TimePickerDialog(this,
            TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                alarmTimeTextView.text = String.format("%d : %d", hourOfDay, minute) },
            hour, minute, false)

        mTimePicker.show()
    }
}