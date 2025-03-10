package com.example.examenandroid.ui.com.example.fakestoreapp.network

import com.example.examenandroid.ui.com.example.fakestoreapp.model.Product
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("products/category/electronics")
    suspend fun getElectronics(): List<Product>

    @GET("products/category/jewelery")
    suspend fun getJewelry(): List<Product>

    @GET("products/category/men's clothing")
    suspend fun getMensClothing(): List<Product>

    @GET("products/category/women's clothing")
    suspend fun getWomensClothing(): List<Product>

    @GET("products/{id}")
    suspend fun getProductDetails(@Path("id") id: Int): Product
}


