package com.example.examenandroid.ui.com.example.fakestoreapp.repository

import com.example.examenandroid.ui.com.example.fakestoreapp.model.Product
import com.example.examenandroid.ui.com.example.fakestoreapp.network.RetrofitClient

class ProductRepository {
    private val apiService = RetrofitClient.apiService

    suspend fun getElectronics(): List<Product> = apiService.getElectronics()
    suspend fun getJewelry(): List<Product> = apiService.getJewelry()
    suspend fun getMensClothing(): List<Product> = apiService.getMensClothing()
    suspend fun getWomensClothing(): List<Product> = apiService.getWomensClothing()
    suspend fun getProductDetails(id: Int): Product = apiService.getProductDetails(id)
}