package com.example.examenandroid.ui.com.example.fakestoreapp.viewmodel


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examenandroid.ui.com.example.fakestoreapp.model.Product
import com.example.examenandroid.ui.com.example.fakestoreapp.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    private val repository = ProductRepository()

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    fun fetchProducts(category: String) {
        viewModelScope.launch {
            try {
                _products.value = when (category) {
                    "electronics" -> repository.getElectronics()
                    "jewelery" -> repository.getJewelry()
                    "men" -> repository.getMensClothing()
                    "women" -> repository.getWomensClothing()
                    else -> emptyList()
                }
            } catch (e: Exception) {
                Log.e("ProductViewModel", "Error fetching products: ${e.message}")
            }
        }
    }

}
