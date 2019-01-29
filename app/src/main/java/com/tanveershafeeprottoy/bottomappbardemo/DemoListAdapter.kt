package com.tanveershafeeprottoy.bottomappbardemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class DemoListAdapter(
    private val dataList: List<String>,
    private val onItemClickListener: ListViewHolder.OnListItemClickListener
) : RecyclerView.Adapter<ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            (LayoutInflater.from(parent.context)).inflate(
                R.layout.row_list,
                parent,
                false
            ), onItemClickListener
        )
    }

    override fun getItemCount(): Int {
        return try {
            dataList.size
        }
        catch(n: NullPointerException) {
            0
        }
    }

    override fun onBindViewHolder(listViewHolder: ListViewHolder, position: Int) {
        try {
            val data = dataList[position]
            listViewHolder.bodyTxtView.text = data
        }
        catch(e: Exception) {
        }
    }
}