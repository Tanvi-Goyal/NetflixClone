package com.example.netflixclone.factory

import android.content.Context
import androidx.core.content.ContextCompat
import com.example.netflixclone.R
import com.example.netflixclone.models.ChildModel
import com.example.netflixclone.models.ChildModelTwo
import java.util.*

object ChildTwoDataFactory {

    private val random = Random()

    private val images = arrayListOf(
        R.drawable.thumbnail_one,
        R.drawable.th_two,
        R.drawable.th_three,
        R.drawable.th_four,
        R.drawable.th_five
    )

    private fun randomImage(): Int {
        val index = random.nextInt(images.size)
        return images[index]
    }

    fun getChildren(context: Context, count: Int): List<ChildModelTwo> {
        val children = mutableListOf<ChildModelTwo>()
        repeat(count) {
            val child = ChildModelTwo(ContextCompat.getDrawable(context, randomImage()))
            children.add(child)
        }
        return children
    }


}