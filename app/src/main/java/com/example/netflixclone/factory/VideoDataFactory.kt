package com.example.netflixclone.factory

import android.content.Context
import androidx.core.content.ContextCompat
import com.example.netflixclone.R
import com.example.netflixclone.models.VideoModel
import java.util.*

object VideoDataFactory {
    private val random = Random()

    private val titles = arrayListOf("Available  Now", "Trending", "Upcoming")

    private val images = arrayListOf(
        R.drawable.thumbnail_one,
        R.drawable.th_two,
        R.drawable.th_three,
        R.drawable.th_four,
        R.drawable.th_five
    )

    private fun randomTitle(): String {
        val index = random.nextInt(titles.size)
        return titles[index]
    }

    private fun randomImage(): Int {
        val index = random.nextInt(images.size)
        return images[index]
    }

    fun getChildren(context: Context, count: Int): List<VideoModel> {
        val children = mutableListOf<VideoModel>()
        repeat(count) {
            val child = VideoModel(randomTitle(), ContextCompat.getDrawable(context, randomImage()))
            children.add(child)
        }
        return children
    }
}