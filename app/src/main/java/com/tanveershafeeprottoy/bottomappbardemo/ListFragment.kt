package com.tanveershafeeprottoy.bottomappbardemo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment() {
    private var listItemClickListener: ListViewHolder.OnListItemClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_list, container, false)
        val recyclerView: RecyclerView = root.recycler
        val values: MutableList<String> = mutableListOf()
        for(i in 1..200) {
            values.add("Content $i")
        }
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            adapter = DemoListAdapter(values, listItemClickListener!!)
        }
        return root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is ListViewHolder.OnListItemClickListener) {
            listItemClickListener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listItemClickListener = null
    }

    companion object {

        @JvmStatic
        fun newInstance() = ListFragment()
    }
}
