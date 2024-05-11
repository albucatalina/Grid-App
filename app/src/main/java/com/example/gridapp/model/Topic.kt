package com.example.gridapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val nameStringResourceId: Int,
    val availableCourses: Int,
    @DrawableRes val imageResourceId: Int
)
