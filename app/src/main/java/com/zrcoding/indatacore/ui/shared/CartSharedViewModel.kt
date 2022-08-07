package com.zrcoding.indatacore.ui.shared

import androidx.lifecycle.ViewModel

class CartSharedViewModel : ViewModel() {
    private val cart = Cart()

    fun addProduct(product: Product?) = product?.let { cart.addProduct(it) }

    fun getProductCount(): Int = cart.getProductCount()

    fun canContinue(): Boolean = !cart.isEmpty()

    fun getCartProductList(): List<Product> = cart.products

    fun removeProduct(product: Product) = cart.removeProduct(product)
}