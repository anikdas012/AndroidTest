package tk.anikdas.anikdas012.androidtestguruklub.network

import io.reactivex.Flowable
import retrofit2.http.GET
import tk.anikdas.anikdas012.androidtestguruklub.model.ListModel

/**
 * Created by "Anik Das" on 30-Dec-2020
 * Developer email: "anikdas012@gmail.com"
 */

interface Listapi {

    @GET("/shows")
    fun list(): Flowable<List<ListModel>>
}