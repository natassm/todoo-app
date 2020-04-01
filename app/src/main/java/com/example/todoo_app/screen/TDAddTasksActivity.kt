package com.example.todoo_app.screen

import android.app.DatePickerDialog
import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.annotation.RequiresApi
import com.example.todoo_app.R
import com.example.todoo_app.support.TDRouter
import com.example.todoo_app.support.base.TDBaseActivity
import kotlinx.android.synthetic.main.activity_add_tasks.*
import kotlinx.android.synthetic.main.activity_dashboard.*
import java.util.*

class TDAddTasksActivity: TDBaseActivity() {

    private var sensorManager: SensorManager? = null
    private var gyroscopeSensor: Sensor? = null

    override fun getContentViewId(): Int = R.layout.activity_add_tasks

    override fun initiateDefaultValue() {
        super.initiateDefaultValue()

        setUpGyroscope()

        setUpSpinner()

        buildOnClickListener(toolbarBackImageView, createNewButton, cancelButton, datePickerButton)
    }

    override fun setOnClickAction(id: Int) {
        super.setOnClickAction(id)
        when (id) {
            R.id.createNewButton -> {
                startActivity(TDRouter.onGoToDashboard(this))
                finish()
            }
            R.id.cancelButton -> {
                startActivity(TDRouter.onGoToDashboard(this))
                finish()
            }
            R.id.datePickerButton -> setCalendar()
        }
    }

    private fun setUpGyroscope() {
        sensorManager = applicationContext.getSystemService(Context.SENSOR_SERVICE) as SensorManager?
        gyroscopeSensor = sensorManager!!.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)

        sensorManager!!.registerListener(gyroscopeSensorEventListener, gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    private var gyroscopeSensorEventListener = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun onSensorChanged(event: SensorEvent) {
            val params = this@TDAddTasksActivity.window.attributes
            if (event.values[2] > 0.5f) {
                params.flags = params.flags or WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                window.attributes = params
                addTasksBackground.background = getDrawable(R.drawable.add_tasks_bg)
            } else if (event.values[2] < -0.5f){
                params.flags = params.flags or WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                window.attributes = params
                addTasksBackground.background = getDrawable(R.drawable.add_tasks_bg_3)
            }
        }
    }

    private fun setCalendar() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                textView4.text = "$dayOfMonth $month, $year"
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }

    private fun setUpSpinner() {

        val listOfItems = arrayOf("Highest", "High", "Medium", "Low", "Lowest")

        val adapterSpinner = ArrayAdapter(this, android.R.layout.simple_spinner_item, listOfItems)
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinner.adapter = adapterSpinner

        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                textView5.text = "Tasks Priority Selected: ${parent?.getItemAtPosition(position).toString()}"
            }
        }
    }
}