package tk.anikdas.anikdas012.androidtestguruklub.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import tk.anikdas.anikdas012.androidtestguruklub.model.ListModel

/**
 * Created by "Anik Das" on 30-Dec-2020
 * Developer email: "anikdas012@gmail.com"
 */

class ListViewModel: ViewModel() {

    private val TAG = "ListViewModel"

    fun getList(): LiveData<List<ListModel>> {
        Log.d(TAG, "getList: called")
    }
}