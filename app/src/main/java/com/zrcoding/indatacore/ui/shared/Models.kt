package com.zrcoding.indatacore.ui.shared

import androidx.annotation.DrawableRes
import java.util.*

data class Product(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val description: String,
    val type: String,
    @DrawableRes val image: Int, // TODO change to url later
    val price: Double,
    var quantity: Int = 0,
)