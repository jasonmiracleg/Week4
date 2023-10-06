package com.example.week4.model

import android.annotation.SuppressLint
import android.content.Context

data class Explore(
    val fileName: String,
) {
    @SuppressLint("DiscouragedApi")
    fun getPhotoID(context:Context): Int {
        return context.resources.getIdentifier(fileName, "drawable", context.packageName)
    }
}
