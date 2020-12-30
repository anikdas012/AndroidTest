package tk.anikdas.anikdas012.androidtestguruklub.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by "Anik Das" on 30-Dec-2020
 * Developer email: "anikdas012@gmail.com"
 */

class RetrofitServiece {

    companion object {
        private var retrofit: Retrofit? = null

        private fun getRetrofitInstance() : Retrofit {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl("http://api.tvmaze.com")
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
            }
            return retrofit!!
        }

        fun getListApi() = getRetrofitInstance().create(Listapi::class.java)

        fun getDetailsApi() = getRetrofitInstance().create(DetailsApi::class.java)
    }
}