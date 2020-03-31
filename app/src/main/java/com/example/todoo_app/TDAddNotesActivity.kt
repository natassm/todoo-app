package com.example.todoo_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todoo_app.support.base.TDBaseActivity

class TDAddNotesActivity : TDBaseActivity() {

    override fun getContentViewId(): Int = R.layout.activity_add_notes

    override fun initiateDefaultValue() {
        super.initiateDefaultValue()

    }
}
