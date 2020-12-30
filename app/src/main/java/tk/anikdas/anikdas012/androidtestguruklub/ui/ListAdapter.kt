package tk.anikdas.anikdas012.androidtestguruklub.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import tk.anikdas.anikdas012.androidtestguruklub.R
import tk.anikdas.anikdas012.androidtestguruklub.model.ListModel
import tk.anikdas.anikdas012.androidtestguruklub.utils.ItemClickListener

/**
 * Created by "Anik Das" on 30-Dec-2020
 * Developer email: "anikdas012@gmail.com"
 */

class ListAdapter(val itemClickListener: ItemClickListener) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private val TAG = "ListAdapter"
    private var items: MutableList<ListModel> = ArrayList()
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.d(TAG, "onCreateViewHolder: called")
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item, parent, false)
        context = parent.context
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: called")
        Glide.with(context)
                .load(items[position].image.medium)
                .centerInside()
                .into(holder.image)
        holder.name.text = items[position].name
        holder.language.text = items[position].language
        holder.gener.text = items[position].genres.toString()

        holder.clear.setOnClickListener {
            removeItem(position)
        }

        holder.item.setOnClickListener {
            if (items[position].id != -1) {
                itemClickListener.onItemClick(items[position].id)
            }
        }
    }

    private fun removeItem(position: Int) {
        Log.d(TAG, "removeItem: called")
        AlertDialog.Builder(context)
                .setTitle("Delete entry")
                .setMessage("Do you really want to remove the entry from list")
                .setPositiveButton(android.R.string.yes) { dialog, which ->
                    items.removeAt(position)
                    notifyDataSetChanged()
                }
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show()
    }

    fun setItems(items: List<ListModel>) {
        Log.d(TAG, "setPosts: called")
        this.items = items.toMutableList()
        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var image: AppCompatImageView = itemView.findViewById(R.id.image)
        var name: AppCompatTextView = itemView.findViewById(R.id.name)
        var language: AppCompatTextView = itemView.findViewById(R.id.language)
        var gener: AppCompatTextView = itemView.findViewById(R.id.genere)
        var clear: AppCompatImageView = itemView.findViewById(R.id.clear)
        var item: CardView = itemView.findViewById(R.id.item)
    }
}