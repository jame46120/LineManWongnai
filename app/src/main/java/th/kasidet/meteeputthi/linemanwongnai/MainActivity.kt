package th.kasidet.meteeputthi.linemanwongnai

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import th.kasidet.meteeputthi.linemanwongnai.data.model.Coin
import th.kasidet.meteeputthi.linemanwongnai.data.model.CoinRankingGet
import th.kasidet.meteeputthi.linemanwongnai.data.remote.ApiUtils
import th.kasidet.meteeputthi.linemanwongnai.data.remote.CoinRankingService


class MainActivity : AppCompatActivity() {
    private var mCoinRankingService: CoinRankingService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mCoinRankingService = ApiUtils().getCoinRankingService()

        pullToRefreshListener()

        displayCoinRanking()
    }

    private fun pullToRefreshListener(){
        val pullToRefresh = findViewById<SwipeRefreshLayout>(R.id.pull_to_refresh)
        pullToRefresh.setOnRefreshListener {
            displayCoinRanking()
            pullToRefresh.isRefreshing = false
        }
    }

    private fun displayCoinRanking() {
        mCoinRankingService?.initCoinRanking()?.enqueue(object:Callback<CoinRankingGet?>{
            override fun onResponse(
                call: Call<CoinRankingGet?>,
                response: Response<CoinRankingGet?>
            ) {
                if(response.body()?.data?.coins?.isNotEmpty() == true && response.isSuccessful){
                    val coins : List<Coin> = response.body()!!.data.coins
                    addCoinToView(coins)
                }
                else{
                    Toast.makeText(applicationContext, response.message(), Toast.LENGTH_LONG).show()
                }
            }
            override fun onFailure(call: Call<CoinRankingGet?>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun addCoinToView(coins : List<Coin>){
        val listView = findViewById<ListView>(R.id.coin_list_view)
        listView.adapter = CoinAdapter(this, coins, this@MainActivity)
    }
}