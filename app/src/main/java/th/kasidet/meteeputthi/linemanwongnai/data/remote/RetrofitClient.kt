package th.kasidet.meteeputthi.linemanwongnai.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    var retrofit: Retrofit? = null

    fun getClient(baseUrl: String): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(baseUrl) // RxJava
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}