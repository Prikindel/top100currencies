package com.invaderprogrammer.android.top100currencies.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.invaderprogrammer.android.top100currencies.rest.CoinGeckoApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class RestModule {

    @Provides
    @Singleton
    fun provideGson(): Gson =
            GsonBuilder()
                .setLenient()
                .create()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(60, TimeUnit.SECONDS)
                .build()

    @Provides
    @Singleton
    @Named("COINGECKO_API")
    fun provideGeckoRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                .baseUrl("https://api.coingecko.com/api/v3/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()

    @Provides
    @Singleton
    fun provideGeckoApiService(@Named("COINGECKO_API") retrofit: Retrofit) : CoinGeckoApi =
            retrofit.create(CoinGeckoApi::class.java)
}