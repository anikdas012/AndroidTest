package tk.anikdas.anikdas012.androidtestguruklub.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * Created by "Anik Das" on 30-Dec-2020
 * Developer email: "anikdas012@gmail.com"
 */

class ListFragment: Fragment() {

    private val TAG = "ListFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: called")
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}