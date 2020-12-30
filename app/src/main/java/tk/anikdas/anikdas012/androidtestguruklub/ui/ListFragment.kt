package tk.anikdas.anikdas012.androidtestguruklub.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import tk.anikdas.anikdas012.androidtestguruklub.databinding.FragmentListBinding
import tk.anikdas.anikdas012.androidtestguruklub.viewmodel.ListViewModel

/**
 * Created by "Anik Das" on 30-Dec-2020
 * Developer email: "anikdas012@gmail.com"
 */

class ListFragment: Fragment() {

    private val TAG = "ListFragment"
    private lateinit var binding: FragmentListBinding
    private lateinit var viewModel: ListViewModel
    private lateinit var adapter: ListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        Log.d(TAG, "onCreateView: called")
        binding = FragmentListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ListViewModel::class.java]
        adapter = ListAdapter()
        initRecyclerView()
        subscribeObservers()
    }

    private fun subscribeObservers() {
        Log.d(TAG, "subscribeObservers: called")
        viewModel.getList().removeObservers(viewLifecycleOwner)
        viewModel.getList().observe(viewLifecycleOwner, Observer { items ->
            if (items != null) {
                if (items[0].id == -1) {
                    Log.e(TAG, "subscribeObservers: Error loading items")
                    Toast.makeText(context, "Data loading error", Toast.LENGTH_LONG).show()
                } else {
                    Log.d(TAG, "subscribeObservers: success")
                    adapter.setItems(items)
                }
            }
        })
    }

    private fun initRecyclerView() {
        Log.d(TAG, "initRecyclerView: called")
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.adapter = adapter
    }
}