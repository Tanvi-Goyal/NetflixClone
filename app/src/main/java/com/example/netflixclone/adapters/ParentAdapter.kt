package com.example.netflixclone.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixclone.BaseViewHolder
import com.example.netflixclone.R
import com.example.netflixclone.databinding.ActivityMainBinding
import com.example.netflixclone.databinding.SubItemBinding
import com.example.netflixclone.databinding.SubRecyclerBinding
import com.example.netflixclone.models.ChildModel
import com.example.netflixclone.models.ParentModel
import com.example.netflixclone.models.VideoModel
import kotlinx.android.synthetic.main.sub_recycler.view.*

class ParentAdapter : RecyclerView.Adapter<BaseViewHolder<*>>() {

    var adapterDataList: List<Any> = emptyList()

    companion object {
        private const val TYPE_RECYCLER = 0
        private const val TYPE_VIDEO = 1
    }

    // methods implemented without data binding
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val v = LayoutInflater.from(parent.context)
//            .inflate(R.layout.sub_recycler,parent,false)
//        return ViewHolder(v)
//    }
//
//    override fun getItemCount(): Int {
//        return parents.size
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder,
//                                  position: Int) {
//        val parent = parents[position]
//        holder.textView.text = parent.title
//        val childLayoutManager = LinearLayoutManager(holder.recyclerView.context, LinearLayout.HORIZONTAL, false)
//        childLayoutManager.initialPrefetchItemCount = 4
//        holder.recyclerView.apply {
//            layoutManager = childLayoutManager
//            adapter = ChildAdapter(parent.children)
//            setRecycledViewPool(viewPool)
//        }
//
//    }


    // methods implemented with data binding
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
////        binding = DataBindingUtil.setContentView<SubRecyclerBinding>(parent.context as Activity, R.layout.activity_main)
//            return ViewHolder(SubRecyclerBinding.inflate(LayoutInflater.from(parent?.context), parent, false))
//    }

//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(items[position])
//    }

//    override fun getItemCount(): Int = items.size


//    var items = listOf<ParentViewModel>()
//        set(value) {
//            field = value
//            notifyDataSetChanged()
//        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (viewType) {
            TYPE_RECYCLER -> {
                return RecyclerViewHolder(
                    SubRecyclerBinding.inflate(
                        LayoutInflater.from(parent?.context),
                        parent,
                        false
                    )
                )
            }

            TYPE_VIDEO -> {
                return VideoViewHolder(
                    SubItemBinding.inflate(
                        LayoutInflater.from(parent?.context),
                        parent,
                        false
                    )
                )
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val element = adapterDataList[position]
        when (holder) {
            is RecyclerViewHolder -> holder.bind(element as ParentModel)
            is VideoViewHolder -> holder.bind(element as VideoModel)
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemCount(): Int {

        return adapterDataList.size
    }

    override fun getItemViewType(position: Int): Int {
        val comparable = adapterDataList[position]
        return when (comparable) {
            is ParentModel -> TYPE_RECYCLER
            is VideoModel -> TYPE_VIDEO
            else -> throw IllegalArgumentException("Invalid type of data " + position)
        }
    }


    // viewholder class with data binding
//    inner class ViewHolder(private val itemBinding: SubRecyclerBinding) : RecyclerView.ViewHolder(itemBinding.root) {
//        fun bind(itemViewModel: ParentViewModel) {
//            itemBinding.parentviewmodel = itemViewModel
//            itemBinding.executePendingBindings()
//
////            val childLayoutManager = LinearLayoutManager(itemBinding.recyclerSub.context, LinearLayout.HORIZONTAL, false)
////            childLayoutManager.initialPrefetchItemCount = 4
////            itemBinding.recyclerSub.apply { layoutManager = childLayoutManager
////            adapter = ChildAdapter(itemViewModel.children)
////            setRecycledViewPool(viewPool)
////        }
//
//            itemBinding.recyclerSub.layoutManager =
//                 LinearLayoutManager(itemBinding.recyclerSub.context, LinearLayout.HORIZONTAL, false)
//            val childAdapter = ChildAdapter()
//            itemBinding.recyclerSub.adapter = childAdapter
//
//            val viewModelList = itemViewModel.children.map {
//                ChildViewModelOne(it.image!!, it.durations)
//            }
//
//            childAdapter.items = viewModelList
//
//
//
//        }
//
//    }


    inner class RecyclerViewHolder(private val itemBinding: SubRecyclerBinding) :
        BaseViewHolder<ParentModel>(itemBinding.root) {

        override fun bind(itemViewModel: ParentModel) {
            itemBinding.parentviewmodel = itemViewModel
            itemBinding.executePendingBindings()

            // sub recycler implemented w/o data binding
//            val childLayoutManager = LinearLayoutManager(itemBinding.recyclerSub.context, LinearLayout.HORIZONTAL, false)
//            childLayoutManager.initialPrefetchItemCount = 4
//            itemBinding.recyclerSub.apply { layoutManager = childLayoutManager
//            adapter = ChildAdapter(itemViewModel.children)
//            setRecycledViewPool(viewPool)
//        }

            // sub recycler implemented with data binding
            itemBinding.recyclerSub.layoutManager =
                LinearLayoutManager(itemBinding.recyclerSub.context, LinearLayout.HORIZONTAL, false)
            val childAdapter = ChildAdapter()
            itemBinding.recyclerSub.adapter = childAdapter

            childAdapter.childAdapterDataList = itemViewModel.children
//
//            parentList.add(recyclerList.get(0))
//            parentList.add(videoList.get(0))
//            parentList.add(recyclerList.get(1))
//            parentList.add(recyclerList.get(2))
//            parentList.add(videoList.get(1))
//
//            parentAdapter.adapterDataList = parentList
//
//

        }
    }

    inner class VideoViewHolder(private val itemBinding: SubItemBinding) :
        BaseViewHolder<VideoModel>(itemBinding.root) {

        override fun bind(itemViewModel: VideoModel) {
            //Do your view assignment here from the data model
            itemBinding.videoviewmodel = itemViewModel
            itemBinding.executePendingBindings()
        }
    }


    // ViewHolder class without data binding
//    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
//        val recyclerView : RecyclerView = itemView.recycler_sub
//        val textView: TextView = itemView.text_title_main
//    }
}