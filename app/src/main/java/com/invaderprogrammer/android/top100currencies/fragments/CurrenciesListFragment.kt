package com.invaderprogrammer.android.top100currencies.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.invaderprogrammer.android.top100currencies.R
import com.invaderprogrammer.android.top100currencies.adapter.BaseAdapter
import com.invaderprogrammer.android.top100currencies.adapter.CurrenciesAdapter
import com.invaderprogrammer.android.top100currencies.di.App
import com.invaderprogrammer.android.top100currencies.mvp.contract.CurrenciesContract
import com.invaderprogrammer.android.top100currencies.mvp.presenter.CurrenciesPresenter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class CurrenciesListFragment : BaseListFragment(), CurrenciesContract.View {

    @Inject
    lateinit var presenter: CurrenciesPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_currencies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.appComponent.inject(this)
        presenter.attach(this)
        presenter.makeList()
    }

    override fun createAdapterInstance(): BaseAdapter<*> {
        return CurrenciesAdapter()
    }

    override fun addCurrency(currency: CurrenciesAdapter.Currency) {
        viewAdapter.add(currency)
    }

    override fun notifyAdapter() {
        viewAdapter.notifyDataSetChanged()
    }

    override fun showProgress() {
        requireActivity().progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        requireActivity().progress.visibility = View.INVISIBLE
    }

    override fun showErrorMessage(error: String?) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT)
    }

    override fun refresh() {
        viewAdapter.items.clear()
        viewAdapter.notifyDataSetChanged()
    }




}
