package com.example.week4.model

import android.annotation.SuppressLint
import android.content.Context

data class Suggestion(
    val name: String,
    val fileName: String,
    val first: Boolean,
    val second: Boolean
) {
    @SuppressLint("DiscouragedApi")
    fun getSuggestionPhoto(context: Context): Int {
        return context.resources.getIdentifier(fileName, "drawable", context.packageName)
    }
}
