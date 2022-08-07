package com.zrcoding.indatacore.ui.cart

import androidx.lifecycle.ViewModel
import com.zrcoding.indatacore.ui.shared.fakeProductList

class CartViewModel : ViewModel() {
    fun getCartProductList() = fakeProductList
}