package com.example.examenandroid.ui.com.example.fakestoreapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.example.examenandroid.ui.com.example.fakestoreapp.model.Product
import com.example.examenandroid.ui.com.example.fakestoreapp.viewmodel.ProductViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@JvmOverloads
@Composable
fun MyApp(viewModel: ProductViewModel = viewModel())
 {
    var selectedCategory by remember { mutableStateOf("electronics") }

    LaunchedEffect(selectedCategory) {
        viewModel.fetchProducts(selectedCategory)
    }

    Column {
        CategorySelector { selectedCategory = it }
        ProductList(viewModel.products.collectAsState().value)
    }
}

@Composable
fun CategorySelector(onCategorySelected: (String) -> Unit) {
    val categories = listOf("electronics", "jewelery", "men", "women")

    Row(modifier = Modifier.padding(8.dp)) {
        categories.forEach { category ->
            Button(
                onClick = { onCategorySelected(category) },
                modifier = Modifier.padding(4.dp)
            ) {
                Text(category)
            }
        }
    }
}

@Composable
fun ProductList(products: List<Product>) {
    LazyColumn {
        items(products) { product ->
            ProductItem(product)
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Card(modifier = Modifier.padding(8.dp).fillMaxWidth()) {
        Column(modifier = Modifier.padding(8.dp)) {
            Image(painter = rememberAsyncImagePainter(product.image), contentDescription = null)
            Text(product.title, style = MaterialTheme.typography.bodyLarge)
            Text("Price: $${product.price}")
        }
    }
}
