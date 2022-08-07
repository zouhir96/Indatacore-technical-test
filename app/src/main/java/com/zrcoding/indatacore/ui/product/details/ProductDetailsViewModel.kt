package com.zrcoding.indatacore.ui.product.details

import androidx.lifecycle.ViewModel
import com.zrcoding.indatacore.ui.shared.Product
import com.zrcoding.indatacore.ui.shared.fakeProductList

class ProductDetailsViewModel : ViewModel() {
    fun getProduct(id: String): Product? = fakeProductList.find { id == it.id }
}