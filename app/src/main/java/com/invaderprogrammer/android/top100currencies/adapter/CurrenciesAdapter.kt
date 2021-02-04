package com.invaderprogrammer.android.top100currencies.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.invaderprogrammer.android.top100currencies.R
import com.invaderprogrammer.android.top100currencies.activities.ChartActivity
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class CurrenciesAdapter :BaseAdapter<CurrenciesAdapter.CurrencyViewHolder>() {

    //создает ViewHolder и инициализирует views для списка
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return CurrencyViewHolder(v)
    }

    //реализация вьюхолдера
    class CurrencyViewHolder(view: View) : BaseAdapter.BaseViewHolder(view) {

        var id: String = ""
        var symbol: String = ""
        var name: String = ""
        var image: String = ""
        var marketCap: String = ""
        var marketCapRank: Int = 0
        var marketCapChangePercentage24h: Float = 0.0f
        var priceChangePercentage24h: Float = 0.0f
        var totalVolume: Float = 0.0f
        var ath: Float = 0.0f
        var athChangePercentage: Float = 0.0f
        var circulatingSupply: Double = 0.0
        var totalSupply: Long = 0


        init {
            //слушатель клика по элементам списка
            itemView.setOnClickListener {
                var intent = Intent(itemView.context, ChartActivity::class.java)
                intent.putExtra("id", id)
                    .putExtra("name", name)
                    .putExtra("symbol", symbol)
                    .putExtra("image", image)
                    .putExtra("marketCapRank", marketCapRank)
                    .putExtra("marketCap", marketCap)
                    .putExtra("marketCapChangePercentage24h", marketCapChangePercentage24h)
                    .putExtra("priceChangePercentage24h", priceChangePercentage24h)
                    .putExtra("totalVolume", totalVolume)
                    .putExtra("ath", ath)
                    .putExtra("athChangePercentage", athChangePercentage)
                    .putExtra("circulatingSupply", circulatingSupply)
                    .putExtra("totalSupply", totalSupply)
                itemView.context.startActivity(intent)
            }
        }


        //привязываем элементы представления списка к RecyclerView и заполняем данными
        override fun bind(item: Any) {
            let {
                item as Currency
                Glide.with(view.context).load(item.image).into(view.ivCurrencyIcon)
                view.tvCurrencySym.text = item.symbol
                view.tvCurrencyName.text = item.name
                view.tvCurrencyMarketCap.text = item.marketCap
                view.tvCurrencyPrice.text = item.price.toString()
                id = item.id
                symbol = item.symbol
                name = item.name
                image = item.image
                marketCapRank = item.marketCapRank
                marketCapChangePercentage24h = item.marketCapChangePercentage24h
                priceChangePercentage24h = item.priceChangePercentage24h
                totalVolume = item.totalVolume
                ath = item.ath
                athChangePercentage = item.athChangePercentage
                circulatingSupply = item.circulatingSupply
                totalSupply = item.totalSupply
            }


        }
    }

    //класс данных для элемента списка
    data class Currency(
        val id: String,
        val symbol: String,
        val name: String,
        val image: String,
        val price: Float,
        val marketCap: String,
        val marketCapRank: Int,
        val totalVolume: Float,
        val priceChangePercentage24h: Float,
        val marketCapChangePercentage24h: Float,
        val circulatingSupply: Double,
        val totalSupply: Long,
        val ath: Float,
        val athChangePercentage: Float
    )
}