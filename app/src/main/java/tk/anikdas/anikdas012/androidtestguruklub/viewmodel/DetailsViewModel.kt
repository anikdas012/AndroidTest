package tk.anikdas.anikdas012.androidtestguruklub.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import io.reactivex.schedulers.Schedulers
import tk.anikdas.anikdas012.androidtestguruklub.model.DetailsModel
import tk.anikdas.anikdas012.androidtestguruklub.model.Image
import tk.anikdas.anikdas012.androidtestguruklub.network.RetrofitServiece

/**
 * Created by "Anik Das" on 31-Dec-2020
 * Developer email: "anikdas012@gmail.com"
 */

class DetailsViewModel : ViewModel() {

    private val TAG = "DetailsViewModel"

    fun getDetails(id: Int) : LiveData<DetailsModel> {
        Log.d(TAG, "getDetails: called")
        return LiveDataReactiveStreams.fromPublisher(
            RetrofitServiece.getDetailsApi().details(id)
                .onErrorReturn {
                    return@onErrorReturn DetailsModel("Error",
                        "Error",
                    "Error",
                             listOf("Error"),
                    "Error",
                             Image("Error", "Error")
                    )
                }
                .subscribeOn(Schedulers.io())
        )
    }
}