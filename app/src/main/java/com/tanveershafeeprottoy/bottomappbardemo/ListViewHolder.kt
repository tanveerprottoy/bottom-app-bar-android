package com.tanveershafeeprottoy.bottomappbardemo

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListViewHolder(
    view: View,
    private val onItemClickListener: OnListItemClickListener
) : RecyclerView.ViewHolder(view) {
    var bodyTxtView: TextView = view.findViewById(R.id.rowListTxtViewBody)

    init {
        view.setOnClickListener {
            onItemClickListener.onItemClick(this.adapterPosition)
        }
    }

    interface OnListItemClickListener {
        fun onItemClick(adapterPosition: Int)
    }
}