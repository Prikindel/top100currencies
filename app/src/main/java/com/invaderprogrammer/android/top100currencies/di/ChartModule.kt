package com.invaderprogrammer.android.top100currencies.di

import com.invaderprogrammer.android.top100currencies.chart.LatestChart
import com.invaderprogrammer.android.top100currencies.formatters.YearValueFormatter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ChartModule {

    @Provides
    @Singleton
    fun provideLatestChart() = LatestChart()



    @Provides
    @Singleton
    fun provideYearFormatter() = YearValueFormatter()

}