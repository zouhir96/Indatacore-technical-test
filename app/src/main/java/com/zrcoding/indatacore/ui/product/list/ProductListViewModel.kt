package com.zrcoding.indatacore.ui.product.list

import androidx.lifecycle.ViewModel
import com.zrcoding.indatacore.ui.shared.fakeProductList

class ProductListViewModel : ViewModel() {

    fun getProductList() = fakeProductList
}