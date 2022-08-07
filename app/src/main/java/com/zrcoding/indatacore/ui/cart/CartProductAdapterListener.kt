package com.zrcoding.indatacore.ui.cart

import com.zrcoding.indatacore.ui.shared.Product

interface CartProductAdapterListener {
    fun onDetailsClicked(product: Product)
    fun onRemoveClicked(product: Product)
    fun onCartCleared()
}