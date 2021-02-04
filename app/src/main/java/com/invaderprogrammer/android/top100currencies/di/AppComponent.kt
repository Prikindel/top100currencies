package com.invaderprogrammer.android.top100currencies.di

import com.invaderprogrammer.android.top100currencies.activities.ChartActivity
import dagger.Component
import com.invaderprogrammer.android.top100currencies.activities.MainActivity
import com.invaderprogrammer.android.top100currencies.chart.LatestChart
import com.invaderprogrammer.android.top100currencies.fragments.CurrenciesListFragment
import com.invaderprogrammer.android.top100currencies.mvp.presenter.CurrenciesPresenter
import com.invaderprogrammer.android.top100currencies.mvp.presenter.LatestChartPresenter
import javax.inject.Singleton

@Component(modules = arrayOf(AppModule::class, RestModule::class, MvpModule::class, ChartModule::class))
@Singleton
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(fragment: CurrenciesListFragment)

    fun inject(presenter: CurrenciesPresenter)
    fun inject(presenter: LatestChartPresenter)

    fun inject(chart: LatestChart)

    fun inject(activity: ChartActivity)

}