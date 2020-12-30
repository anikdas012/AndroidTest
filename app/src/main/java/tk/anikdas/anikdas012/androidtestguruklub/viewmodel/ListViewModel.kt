package tk.anikdas.anikdas012.androidtestguruklub.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import io.reactivex.schedulers.Schedulers
import tk.anikdas.anikdas012.androidtestguruklub.model.Image
import tk.anikdas.anikdas012.androidtestguruklub.model.ListModel
import tk.anikdas.anikdas012.androidtestguruklub.network.RetrofitServiece

/**
 * Created by "Anik Das" on 30-Dec-2020
 * Developer email: "anikdas012@gmail.com"
 */

class ListViewModel: ViewModel() {

    private val TAG = "ListViewModel"

    fun getList(): LiveData<List<ListModel>> {
        Log.d(TAG, "getList: called")
        return LiveDataReactiveStreams.fromPublisher(
            RetrofitServiece.getListApi().list()
                .onErrorReturn {
                    Log.d(TAG, "getList: error")
                    return@onErrorReturn listOf<ListModel>(
                        ListModel(-1, "Error", "Error", listOf("Error"), Image("Error", "Error"))
                    )
                }
                .subscribeOn(Schedulers.io())
        )
    }
}