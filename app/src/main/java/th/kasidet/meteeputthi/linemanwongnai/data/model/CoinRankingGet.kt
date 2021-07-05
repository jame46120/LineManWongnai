package th.kasidet.meteeputthi.linemanwongnai.data.model

import com.google.gson.annotations.SerializedName

data class CoinRankingGet(
    @SerializedName("data") val data: Data,
    @SerializedName("status") val status: String
)

data class Data(
    @SerializedName("coins") val coins: List<Coin>
)

data class Coin(
    @SerializedName("description") val description: String,
    @SerializedName("iconUrl") val iconUrl: String,
    @SerializedName("name") val name: String,
)