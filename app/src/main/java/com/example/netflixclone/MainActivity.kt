package com.example.netflixclone

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixclone.adapters.ParentAdapter
import com.example.netflixclone.databinding.ActivityMainBinding
import com.example.netflixclone.factory.ChildDataFactory
import com.example.netflixclone.factory.ParentDataFactory
import com.example.netflixclone.factory.VideoDataFactory
import com.example.netflixclone.models.ChildModel
import com.example.netflixclone.models.ParentModel
import com.example.netflixclone.models.VideoModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private var parentList: ArrayList<Any> = ArrayList()
    private lateinit var recyclerList: List<ParentModel>
    private lateinit var videoList: List<VideoModel>

    lateinit var binding: com.example.netflixclone.databinding.ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ParentDataFactory.initialize(application)
        recyclerList = ParentDataFactory.getParents(application, 40)
        videoList = VideoDataFactory.getChildren(application,40)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        initRecycler()
    }

    @SuppressLint("WrongConstant")
    private fun initRecycler() {

        binding.recyclerMain.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val parentAdapter = ParentAdapter()
        binding.recyclerMain.adapter = parentAdapter

        parentList.add(recyclerList.get(0))
        parentList.add(videoList.get(0))
        parentList.add(recyclerList.get(1))
        parentList.add(recyclerList.get(2))
        parentList.add(videoList.get(1))

        parentAdapter.adapterDataList = parentList

//
//        binding.recyclerMain.apply {
//            binding.recyclerMain.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayout.VERTICAL, false)
//            adapter = ParentAdapter(ParentDataFactory.getParents(40))
//        }
////        val adapter = ParentAdapter(ParentDataFactory.getParents(40))
////        binding.recyclerMain.adapter = adapter
//
//        val viewModelList = list.map {
//            ParentViewModel(it.position.toString(), "${it.firstName} ${it.lastName}", it.teamName, it.id.contentEquals(myUserId))
//        }
//
//        adapter.items = viewModelList
//

//        recycler_main.apply {
//            layoutManager = LinearLayoutManager(this@MainActivity,
//                LinearLayout.VERTICAL, false)
//            adapter = ParentAdapter(
//                ParentDataFactory
//                .getParents(40))
//        }

    }
}
