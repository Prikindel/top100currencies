package com.invaderprogrammer.android.top100currencies.rest

data class GeckoCoin (
    val id: String,
    val symbol: String,
    val name: String,
    val image: String,
    val current_price: Float,
    val market_cap: Float,
    val market_cap_rank: Int,
    val total_volume: Float,
    val price_change_percentage_24h: Float,
    val market_cap_change_percentage_24h: Float,
    val circulating_supply: Double,
    val total_supply: Long,
    val ath: Float,
    val ath_change_percentage: Float
)

data class GeckoCoinChart (
    var prices: List<List<Float>>
)