package tk.anikdas.anikdas012.androidtestguruklub.ui

import android.os.Bundle
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }
}