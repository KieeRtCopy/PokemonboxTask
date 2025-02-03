package com.example.common.base_component

import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<T, VH : RecyclerView.ViewHolder>(
    private var itemList: List<T>,
    protected val itemClickListener: OnItemClickListener<T>
) : RecyclerView.Adapter<VH>() {

    interface OnItemClickListener<T> {
        fun onItemClick(item: T, position: Int)
    }

    override fun getItemCount(): Int = itemList.size

    fun getItem(position: Int): T = itemList[position]

    fun setItemList(newList: List<T>) {
        itemList = newList
        notifyDataSetChanged()
    }
}