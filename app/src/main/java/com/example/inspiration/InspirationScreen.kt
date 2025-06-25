package com.example.inspiration

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController

@Composable
fun InspirationApp (
    viewModel: InspirationViewModel = viewModel(), navController: NavHostController = rememberNavController())