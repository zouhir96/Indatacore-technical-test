package com.zrcoding.indatacore.ui.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.zrcoding.indatacore.R


class Steps @JvmOverloads constructor(
    ctx: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(ctx, attrs, defStyleAttr) {

    private var step1: View
    private var step2: View
    private var step3: View
    private var step4: View
    private var step5: View

    init {
        inflate(context, R.layout.layout_steps, this)
        step1 = findViewById(R.id.step1)
        step2 = findViewById(R.id.step2)
        step3 = findViewById(R.id.step3)
        step4 = findViewById(R.id.step4)
        step5 = findViewById(R.id.step5)
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.Steps,
            0, 0
        ).apply {
            try {
                val step = getInteger(R.styleable.Steps_step, 0)
                setStep(step)
            } finally {
                recycle()
            }
        }
    }


    fun setStep(step: Int) {
        listOf(step1, step2, step3, step4, step5).forEachIndexed { index, view ->
            view.background = ContextCompat.getDrawable(
                context,
                if (index + 1 <= step) {
                    R.drawable.shape_step_filled
                } else {
                    R.drawable.shape_step_unfilled
                }
            )
        }
    }
}