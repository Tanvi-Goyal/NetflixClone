package com.example.netflixclone.factory

import android.content.Context
import androidx.core.content.ContextCompat
import com.example.netflixclone.R
import com.example.netflixclone.models.ChildModel
import java.util.*

object ChildDataFactory {

    private val random = Random()

    private val titles = arrayListOf("1h 40m", "1h 15m", "2h 10m", "1h 50m", "2h 30m")
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

    fun getChildren(context: Context, count: Int): List<ChildModel> {
        val children = mutableListOf<ChildModel>()
        repeat(count) {
            val child = ChildModel(ContextCompat.getDrawable(context, randomImage()), randomTitle())
            children.add(child)
        }
        return children
    }


}