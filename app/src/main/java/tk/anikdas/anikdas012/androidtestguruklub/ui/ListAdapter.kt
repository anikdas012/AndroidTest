package tk.anikdas.anikdas012.androidtestguruklub.ui

import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import tk.anikdas.anikdas012.androidtestguruklub.R
import tk.anikdas.anikdas012.androidtestguruklub.model.ListModel

/**
 * Created by "Anik Das" on 30-Dec-2020
 * Developer email: "anikdas012@gmail.com"
 */

class ListAdapter : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private val TAG = "ListAdapter"
    private var items: List<ListModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var image: AppCompatImageView = itemView.findViewById(R.id.image)
        var name: AppCompatTextView = itemView.findViewById(R.id.name)
        var language: AppCompatTextView = itemView.findViewById(R.id.language)
        var gener: AppCompatTextView = itemView.findViewById(R.id.genere)
        var clear: AppCompatImageView = itemView.findViewById(R.id.clear)
    }
}