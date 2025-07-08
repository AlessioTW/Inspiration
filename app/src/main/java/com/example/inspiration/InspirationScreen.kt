package com.example.inspiration

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.inspiration.ui.InspirationViewModel

@Composable
fun InspirationApp (
    viewModel: InspirationViewModel = viewModel(),
    navController: NavHostController = rememberNavController())