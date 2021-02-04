package com.invaderprogrammer.android.top100currencies.mvp.contract

import com.invaderprogrammer.android.top100currencies.adapter.CurrenciesAdapter

class CurrenciesContract {
    interface View : BaseContract.View {
        fun addCurrency(currency: CurrenciesAdapter.Currency)
        fun notifyAdapter()
        fun showProgress()
        fun hideProgress()
        fun showErrorMessage(error: String?)
        fun refresh()
    }

    abstract class Presenter: BaseContract.Presenter<View>() {
        abstract fun makeList()
        abstract fun refreshList()
    }
}