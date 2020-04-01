package com.example.todoo_app.screen

import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.os.Build
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.LayoutInflater
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import android.widget.*
import com.example.todoo_app.R
import com.example.todoo_app.support.TDRouter
import com.example.todoo_app.support.base.TDBaseActivity
import kotlinx.android.synthetic.main.activity_add_tasks.*
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_list_notes.*
import kotlinx.android.synthetic.main.activity_list_notes.tasksTextView
import kotlinx.android.synthetic.main.activity_list_tasks.toolbarBackImageView

class TDListNotesActivity: TDBaseActivity() {

    override fun getContentViewId(): Int = R.layout.activity_list_notes

    override fun initiateDefaultValue() {
        super.initiateDefaultValue()

        buildOnClickListener(listNotesImageView, toolbarBackImageView)

        setUpAnimation()
    }

    override fun setOnClickAction(id: Int) {
        super.setOnClickAction(id)
        when (id) {
            R.id.listNotesImageView -> {
                val inflater: LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                val view = inflater.inflate(R.layout.activity_add_notes, null)
                val popupWindow = PopupWindow(
                    view,
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    popupWindow.elevation = 10.0F
                }

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    val slideIn = Slide()
                    slideIn.slideEdge = Gravity.TOP
                    popupWindow.enterTransition = slideIn

                    val slideOut = Slide()
                    slideOut.slideEdge = Gravity.RIGHT
                    popupWindow.exitTransition = slideOut
                }

                val cancelButtonPopup = view.findViewById<Button>(R.id.addNotesCancelbutton)
                val createButtonPopUp = view.findViewById<Button>(R.id.addNotesCreateNewButton)

                cancelButtonPopup.setOnClickListener {
                    popupWindow.dismiss()
                }

                createButtonPopUp.setOnClickListener {
                    popupWindow.dismiss()
                }

                popupWindow.setOnDismissListener {
                    Toast.makeText(applicationContext,"Popup closed",Toast.LENGTH_SHORT).show()
                }

                TransitionManager.beginDelayedTransition(root_layout)
                popupWindow.showAtLocation(
                    root_layout, // Location to display popup window
                    Gravity.CENTER, // Exact position of layout to display popup
                    0, // X offset
                    0 // Y offset
                )
            }
        }
    }

    private fun setUpAnimation() {
        val animation = AnimationUtils.loadAnimation(this, R.anim.splash_animation)
        tasksTextView.startAnimation(animation)

        val animation2 = AnimationUtils.loadAnimation(this, R.anim.move)
        listNotesCardView.startAnimation(animation2)

        val animation3 = AnimationUtils.loadAnimation(this, R.anim.slide_up)
        listNotesCardView2.startAnimation(animation3)

        val animation4 = AnimationUtils.loadAnimation(this, R.anim.slide_down)
        listNotesCardView3.startAnimation(animation4)
    }
}