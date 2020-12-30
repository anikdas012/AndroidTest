package tk.anikdas.anikdas012.androidtestguruklub.ui

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import tk.anikdas.anikdas012.androidtestguruklub.databinding.FragmentDetailsBinding
import tk.anikdas.anikdas012.androidtestguruklub.viewmodel.DetailsViewModel

/**
 * Created by "Anik Das" on 30-Dec-2020
 * Developer email: "anikdas012@gmail.com"
 */

class DetailsFragment : Fragment() {

    private val TAG = "DetailsFragment"
    private lateinit var binding: FragmentDetailsBinding
    private lateinit var viewModel: DetailsViewModel
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
        viewModel = ViewModelProvider(this)[DetailsViewModel::class.java]
        binding.back.setOnClickListener {
            returnToListView()
        }
        subscribeObserver()
    }

    private fun returnToListView() {
        TODO("Not yet implemented")
    }

    private fun subscribeObserver() {
        Log.d(TAG, "subscribeObserver: called")
        viewModel.getDetails(id!!).removeObservers(viewLifecycleOwner)
        viewModel.getDetails(id!!).observe(viewLifecycleOwner, Observer { details ->
            if (details.type != "Error") {
                Glide.with(this)
                    .load(details.image.original)
                    .centerInside()
                    .into(binding.image)
                binding.name.text = details.name
                binding.type.text = details.type
                binding.language.text = details.language
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    binding.summary.text = Html.fromHtml(details.summary, Html.FROM_HTML_MODE_COMPACT)
                } else {
                    binding.summary.text = Html.fromHtml(details.summary)
                }
                binding.genere.text = details.genres.toString()
            } else {
                Toast.makeText(context, "Loading error", Toast.LENGTH_LONG).show()
            }
        })
    }
}