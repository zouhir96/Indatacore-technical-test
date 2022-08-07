package com.zrcoding.indatacore.ui.shared

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter

@BindingAdapter("image")
fun setImage(imageView: ImageView, image: Int) {
    imageView.setImageDrawable(ContextCompat.getDrawable(imageView.context, image))
}