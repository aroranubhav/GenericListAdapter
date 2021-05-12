package com.maxi.genericlistadapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class BaseListAdapter<T : Any> :
    ListAdapter<T, RecyclerView.ViewHolder>(BaseItemCallBack()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return getViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(viewType, parent, false), viewType
        )
    }

    abstract fun getViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder

    override fun getItemViewType(position: Int): Int =
        getLayoutId(position, getItem(position))

    protected abstract fun getLayoutId(position: Int, obj: T): Int

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as Binder<T>).bind(getItem(position))
    }

    internal interface Binder<T> {
        fun bind(data: T)
    }

    override fun getItemCount(): Int = currentList.size
}


class BaseItemCallBack<T : Any> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean =
        oldItem.toString() == newItem.toString()


    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean =
        oldItem == newItem
}