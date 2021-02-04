package com.invaderprogrammer.android.top100currencies.di

import com.invaderprogrammer.android.top100currencies.mvp.presenter.CurrenciesPresenter
import com.invaderprogrammer.android.top100currencies.mvp.presenter.LatestChartPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MvpModule {

    @Provides
    @Singleton
    fun provideCurrenciesPresenter(): CurrenciesPresenter = CurrenciesPresenter()

    @Provides
    @Singleton
    fun provideLatestChartPresenter(): LatestChartPresenter = LatestChartPresenter()
}