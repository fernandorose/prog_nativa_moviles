package com.example.material_design.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Hero(
  @StringRes val nameRes: Int,
  @StringRes val descriptionRes: Int,
  @DrawableRes val imageRes: Int
)