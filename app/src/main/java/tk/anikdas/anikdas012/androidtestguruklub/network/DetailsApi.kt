package tk.anikdas.anikdas012.androidtestguruklub.network

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import tk.anikdas.anikdas012.androidtestguruklub.model.DetailsModel

/**
 * Created by "Anik Das" on 30-Dec-2020
 * Developer email: "anikdas012@gmail.com"
 */

interface DetailsApi {

    @GET("/shows/{id}")
    fun details(@Path("id") id: Int): Flowable<DetailsModel>
}