package com.maxi.genericlistadapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

object BaseViewHolder {

    fun create(view: View, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.row_item_text -> StringViewHolder(view)
            else -> {
                StringViewHolder(view)
            }
        }
    }

    class StringViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        BaseListAdapter.Binder<String> {

        var textView: TextView = itemView.findViewById(R.id.tvText)

        override fun bind(data: String) {
            textView.text = data
        }
    }
}