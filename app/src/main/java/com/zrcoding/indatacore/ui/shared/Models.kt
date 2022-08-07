package com.zrcoding.indatacore.ui.shared

import androidx.annotation.DrawableRes

data class Product(
    val name: String,
    val description: String,
    val type: String,
    @DrawableRes val image: Int, // TODO change to url later
)