package tk.anikdas.anikdas012.androidtestguruklub.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import tk.anikdas.anikdas012.androidtestguruklub.databinding.FragmentDetailsBinding

/**
 * Created by "Anik Das" on 30-Dec-2020
 * Developer email: "anikdas012@gmail.com"
 */

class DetailsFragment : Fragment() {

    private val TAG = "DetailsFragment"
    private lateinit var binding: FragmentDetailsBinding
    private var id: Int? = null
    private var movieName: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        Log.d(TAG, "onCreateView: called")
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        id = arguments!!.getInt("id")
        movieName = arguments!!.getString("name")
        binding.title.text = movieName
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(TAG, "onViewCreated: called")
    }
}