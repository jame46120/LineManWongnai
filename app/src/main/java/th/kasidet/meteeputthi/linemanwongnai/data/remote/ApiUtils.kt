package th.kasidet.meteeputthi.linemanwongnai.data.remote


class ApiUtils {
    private fun ApiUtils() {}
    val URL = "https://api.coinranking.com/v1/public/"

    fun getCoinRankingService(): CoinRankingService? {
        return RetrofitClient().getClient(URL)?.create(CoinRankingService::class.java)
    }
}