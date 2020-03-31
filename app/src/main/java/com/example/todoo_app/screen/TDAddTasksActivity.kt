package com.example.todoo_app.screen

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.view.WindowManager
import androidx.annotation.RequiresApi
import com.example.todoo_app.R
import com.example.todoo_app.support.base.TDBaseActivity
import kotlinx.android.synthetic.main.activity_add_tasks.*
import kotlinx.android.synthetic.main.activity_dashboard.*

class TDAddTasksActivity: TDBaseActivity() {

    private var sensorManager: SensorManager? = null
    private var gyroscopeSensor: Sensor? = null

    override fun getContentViewId(): Int = R.layout.activity_add_tasks

    override fun initiateDefaultValue() {
        super.initiateDefaultValue()

        setUpGyroscope()
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
}