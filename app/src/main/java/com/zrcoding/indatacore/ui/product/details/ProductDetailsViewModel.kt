package com.zrcoding.indatacore.ui.product.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zrcoding.indatacore.core.Resource
import com.zrcoding.indatacore.data.repository.ProductRepository
import com.zrcoding.indatacore.data.repository.ProductRepositoryImpl
import com.zrcoding.indatacore.data.sources.fake.FakeDataSource
import com.zrcoding.indatacore.ui.shared.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ProductDetailsViewModel : ViewModel() {
    private val productRepository: ProductRepository = ProductRepositoryImpl(FakeDataSource())

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