package com.example.week4.model

import android.annotation.SuppressLint
import android.content.Context
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class Feed(
    val name: String,
    val profileName: String,
    val feedName: String,
    val first: Boolean,
    val second: Boolean,
    val likes: Int,
    val caption: String,
    val date: String
){
    @SuppressLint("DiscouragedApi")
    fun getProfilePhoto(context: Context): Int {
        return context.resources.getIdentifier(profileName, "drawable", context.packageName)
    }
    @SuppressLint("DiscouragedApi")
    fun getFeedPhoto(context:Context): Int {
        return context.resources.getIdentifier(feedName, "drawable", context.packageName)
    }

    fun formatDate(): String {
        val input = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        val output = SimpleDateFormat("MMMM d, yyyy", Locale.US)

        val currentYear = SimpleDateFormat("yyyy", Locale.US).format(Date())
        val dateYear = SimpleDateFormat("yyyy", Locale.US).format(input.parse(date) as Date)

        return if (currentYear == dateYear) {
            output.applyPattern("MMMM d")
            output.format(input.parse(date) as Date)
        } else {
            output.format(input.parse(date) as Date)
        }
    }
}
