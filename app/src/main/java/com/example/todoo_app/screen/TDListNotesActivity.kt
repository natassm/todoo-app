package com.example.todoo_app.screen

import com.example.todoo_app.R
import com.example.todoo_app.support.TDRouter
import com.example.todoo_app.support.base.TDBaseActivity
import kotlinx.android.synthetic.main.activity_list_notes.*
import kotlinx.android.synthetic.main.activity_list_tasks.toolbarBackImageView

class TDListNotesActivity: TDBaseActivity() {

    override fun getContentViewId(): Int = R.layout.activity_list_notes

    override fun initiateDefaultValue() {
        super.initiateDefaultValue()

        buildOnClickListener(listNotesImageView, toolbarBackImageView)
    }

    override fun setOnClickAction(id: Int) {
        super.setOnClickAction(id)
        when (id) {
//            R.id.listTasksImageView -> startActivity(TDRouter.onGoToListNotes(this@TDListNotesActivity))
        }
    }
}