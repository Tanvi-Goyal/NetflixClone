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

    private fun randomTitle() : String{
        val index = random.nextInt(titles.size)
        return titles[index]
    }

    private fun randomChildren(context: Context, type: Int) : List<Any>{
        if(type == 0) {
            return ChildDataFactory.getChildren(context, 20)
        }else return ChildTwoDataFactory.getChildren(context,20)

    }

    fun getParents(context: Context, count : Int, type: Int) : List<ParentModel>{
        val parents = mutableListOf<ParentModel>()
        repeat(count){
            val parent = ParentModel(randomTitle(), randomChildren(context,type))
            parents.add(parent)
        }
        return parents
    }


}