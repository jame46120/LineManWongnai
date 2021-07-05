package th.kasidet.meteeputthi.linemanwongnai.data.remote

import retrofit2.Call
import retrofit2.http.*
import th.kasidet.meteeputthi.linemanwongnai.data.model.CoinRankingGet

interface CoinRankingService {
    @GET("coins")
    fun initCoinRanking(): Call<CoinRankingGet?>?
}