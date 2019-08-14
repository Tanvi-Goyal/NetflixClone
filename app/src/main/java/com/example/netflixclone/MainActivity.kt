package com.example.netflixclone

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.netflixclone.adapters.ParentAdapter
import com.example.netflixclone.databinding.ActivityMainBinding
import com.example.netflixclone.factory.ParentDataFactory
import com.example.netflixclone.factory.VideoDataFactory
import com.example.netflixclone.models.ParentModel
import com.example.netflixclone.models.VideoModel

class MainActivity : AppCompatActivity() {

    private var parentList: ArrayList<Any> = ArrayList()
    private lateinit var videoRecyclerList: List<ParentModel>
    private lateinit var imageRecyclerList: List<ParentModel>

    private lateinit var videoList: List<VideoModel>

    lateinit var binding: com.example.netflixclone.databinding.ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        videoRecyclerList = ParentDataFactory.getParents(application, 40, 0)
        imageRecyclerList = ParentDataFactory.getParents(application, 40, 1)

        videoList = VideoDataFactory.getChildren(application, 40)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        initRecycler()
    }

    private fun initRecycler() {

        binding.recyclerMain.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val parentAdapter = ParentAdapter()
        binding.recyclerMain.adapter = parentAdapter

        parentList.add(videoRecyclerList.get(0))
        parentList.add(videoList.get(0))
        parentList.add(imageRecyclerList.get(0))
        parentList.add(videoRecyclerList.get(1))
        parentList.add(videoList.get(1))

        parentAdapter.adapterDataList = parentList
    }
}
