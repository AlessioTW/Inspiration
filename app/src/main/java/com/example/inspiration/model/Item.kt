package com.example.inspiration.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Item(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageId: Int,
    val description: String
)
