package com.example.netflixclone.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.netflixclone.BaseViewHolder
import com.example.netflixclone.databinding.SubRecyclerItemOneBinding
import com.example.netflixclone.databinding.SubRecyclerItemTwoBinding
import com.example.netflixclone.models.ChildModel
import com.example.netflixclone.models.ChildModelTwo

class ChildAdapter : RecyclerView.Adapter<BaseViewHolder<*>>() {

    var childAdapterDataList: List<Any> = emptyList()

    companion object {
        private const val TYPE_VIDEO = 0
        private const val TYPE_IMAGE = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (viewType) {
            TYPE_VIDEO -> {
                return ChildVideoViewHolder(
                    SubRecyclerItemOneBinding.inflate(
                        LayoutInflater.from(parent?.context),
                        parent,
                        false
                    )
                )
            }

            TYPE_IMAGE -> {
                return ChildImageViewHolder(
                    SubRecyclerItemTwoBinding.inflate(
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
        val element = childAdapterDataList[position]
        when (holder) {
            is ChildVideoViewHolder -> holder.bind(element as ChildModel)
            is ChildImageViewHolder -> holder.bind(element as ChildModelTwo)
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemCount(): Int {

        return childAdapterDataList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (childAdapterDataList[position]) {
            is ChildModel -> TYPE_VIDEO
            is ChildModelTwo -> TYPE_IMAGE
            else -> throw IllegalArgumentException("Invalid type of data " + position)
        }
    }

    inner class ChildVideoViewHolder(private val itemBinding: SubRecyclerItemOneBinding) :
        BaseViewHolder<ChildModel>(itemBinding.root) {

        override fun bind(itemViewModel: ChildModel) {
            //Do your view assignment here from the data model
            itemBinding.childviewmodelone = itemViewModel
            itemBinding.executePendingBindings()
        }
    }


    inner class ChildImageViewHolder(private val itemBinding: SubRecyclerItemTwoBinding) :
        BaseViewHolder<ChildModelTwo>(itemBinding.root) {

        override fun bind(itemViewModel: ChildModelTwo) {
            itemBinding.childviewmodeltwo = itemViewModel
            itemBinding.executePendingBindings()

        }
    }

}