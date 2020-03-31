package com.example.todoo_app.screen

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoo_app.support.base.TDBaseActivity
import com.example.todoo_app.R
import com.example.todoo_app.support.TDRouter
import com.example.todoo_app.support.adapter.recyclerview.TDTasksListAdapter
import com.example.todoo_app.support.adapter.recyclerview.viewholder.TasksListEntity
import kotlinx.android.synthetic.main.activity_dashboard.*

class TDDashboardActivity : TDBaseActivity(){

    private var sensorManager: SensorManager? = null
    private var proximitySensor: Sensor? = null

    private lateinit var tasksListAdapter: TDTasksListAdapter

    private var proximitySensorEventListener = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

        override fun onSensorChanged(event: SensorEvent) {
            val params = this@TDDashboardActivity.window.attributes
            if (event.values[0] == 0f) {
                params.flags = params.flags or WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                params.screenBrightness = 0f
                window.attributes = params
                proximitySensorTextView2.text = getString(R.string.too_near)
                proximitySensorTextView2.setTextColor(resources.getColor(android.R.color.black))
            } else {
                params.flags = params.flags or WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                params.screenBrightness = -1f
                window.attributes = params
                proximitySensorTextView2.text = getString(R.string.far_away)
                proximitySensorTextView2.setTextColor(resources.getColor(android.R.color.holo_red_dark))

            }
        }
    }

    override fun getContentViewId(): Int = R.layout.activity_dashboard

    override fun initiateDefaultValue() {
        super.initiateDefaultValue()

        buildOnClickListener(dashboardTasksActivityCardView)

        setUpProximitySensor()

        setUpRecyclerView()

        val animation = AnimationUtils.loadAnimation(this, R.anim.splash_animation)
        dashboardIntroTextView.startAnimation(animation)
    }

    override fun setOnClickAction(id: Int) {
        super.setOnClickAction(id)
        when (id) {
            R.id.dashboardTasksActivityCardView -> startActivity(TDRouter.onGoToListTasks(this@TDDashboardActivity))
        }
    }

    private fun setUpProximitySensor() {
        sensorManager = applicationContext.getSystemService(Context.SENSOR_SERVICE) as SensorManager?
        proximitySensor = sensorManager!!.getDefaultSensor(Sensor.TYPE_PROXIMITY)

        if (proximitySensor == null) {
            proximitySensorTextView.text == getString(R.string.no_proximity)
        } else {
            sensorManager!!.registerListener(proximitySensorEventListener, proximitySensor, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    private fun setUpRecyclerView() {
        val list = listOf(
            TasksListEntity("Urgent", "Kerjain Project", "Project UI/UX", "31/03/2020"),
            TasksListEntity("Urgent", "Kerjain Project", "Project UI/UX", "31/03/2020"),
            TasksListEntity("Urgent", "Kerjain Project", "Project UI/UX", "31/03/2020"),
            TasksListEntity("Urgent", "Kerjain Project", "Project UI/UX", "31/03/2020"),
            TasksListEntity("Urgent", "Kerjain Project", "Project UI/UX", "31/03/2020"),
            TasksListEntity("Urgent", "Kerjain Project", "Project UI/UX", "31/03/2020")
        )

        tasksListAdapter = TDTasksListAdapter(list)

        dashboardLatestTaskRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            itemAnimator = DefaultItemAnimator()
            adapter = tasksListAdapter
        }
    }
}
