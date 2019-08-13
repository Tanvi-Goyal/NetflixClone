package com.example.netflixclone.factory

import android.content.Context
import com.example.netflixclone.models.ChildModel
import com.example.netflixclone.models.ChildModelTwo
import com.example.netflixclone.models.ParentModel
import com.example.netflixclone.models.VideoModel
import java.util.*

object ParentDataFactory{
    private val random = Random()

    private val titles =  arrayListOf( "Now Playing", "Classic", "Comedy", "Thriller", "Action", "Horror", "TV Series")

    private var childList: ArrayList<Any> = ArrayList()
    private lateinit var videoList: List<ChildModel>
    private lateinit var imageList: List<ChildModelTwo>

    fun initialize(context: Context) {
        videoList = ChildDataFactory.getChildren(context, 20)
        imageList = ChildTwoDataFactory.getChildren(context,20)
    }

    private fun randomTitle() : String{
        val index = random.nextInt(titles.size)
        return titles[index]
    }

    private fun randomChildren(context: Context) : List<Any>{

        childList.add(videoList.get(0))
        childList.add(imageList.get(0))

        return childList
    }

    fun getParents(context: Context, count : Int) : List<ParentModel>{
        val parents = mutableListOf<ParentModel>()
        repeat(count){
            val parent = ParentModel(randomTitle(), randomChildren(context))
            parents.add(parent)
        }
        return parents
    }


}