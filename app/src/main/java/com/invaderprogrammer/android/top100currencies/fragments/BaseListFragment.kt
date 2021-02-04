package com.invaderprogrammer.android.top100currencies.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.invaderprogrammer.android.top100currencies.R
import com.invaderprogrammer.android.top100currencies.adapter.BaseAdapter

abstract class BaseListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    protected lateinit var viewAdapter: BaseAdapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewManager = LinearLayoutManager(context)
        viewAdapter = createAdapterInstance()

        recyclerView = view.findViewById<RecyclerView>(R.id.list).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

    abstract fun createAdapterInstance() : BaseAdapter<*>
}