package com.invaderprogrammer.android.top100currencies.mvp.presenter

import com.invaderprogrammer.android.top100currencies.di.App
import com.invaderprogrammer.android.top100currencies.mvp.contract.LatestChartContract
import com.invaderprogrammer.android.top100currencies.rest.CoinGeckoApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LatestChartPresenter : LatestChartContract.Presenter() {

    @Inject
    lateinit var geckoApi: CoinGeckoApi


    init {
        App.appComponent.inject(this)
    }

    override fun makeChart(id: String) {

        subscribe(geckoApi.getCoinMarketChart(id)


            .map { it.prices }

            .flatMap { Observable.fromIterable(it) }

            .doOnComplete {

                view.hideProgress()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.hideProgress()
                view.addEntryToChart(it[0], it[1])

            }, {
                view.hideProgress()
                view.showErrorMessage(it.message)
                it.printStackTrace()
            })
        )

    }

    override fun refreshChart() {
        view.refresh()

    }



}
