package com.example.inspiration.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Item(
    @StringRes val titolo: Int,
    @DrawableRes val imageId: Int,
    @StringRes val description: Int,
    val vip: Boolean = false
)
