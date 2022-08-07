package com.zrcoding.indatacore.ui.product.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zrcoding.indatacore.core.Resource
import com.zrcoding.indatacore.data.repository.ProductRepository
import com.zrcoding.indatacore.ui.shared.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    val product: MutableStateFlow<Product?> = MutableStateFlow(null)

    fun getProduct(id: String) {
        viewModelScope.launch {
            productRepository.getProduct(id).collect {
                when (it) {
                    is Resource.Loading -> {
                        // todo add loading (need design)
                    }
                    is Resource.Success -> {
                        product.emit(it.data)
                    }
                    is Resource.Error -> {
                        // todo add error handle (need design)
                    }
                }
            }
        }
    }

}