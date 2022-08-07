package com.zrcoding.indatacore.ui

import android.os.Bundle
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.zrcoding.indatacore.R
import com.zrcoding.indatacore.ui.widgets.Steps

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun changeStep(step: Int) {
        findViewById<Steps>(R.id.steps).setStep(step)
    }

    fun changeTitle(@StringRes title: Int) {
        findViewById<TextView>(R.id.title).text = getString(title)
    }
}