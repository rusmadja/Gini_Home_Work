package com.reouven.app_using_api_in_view.view.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.reouven.app_using_api_in_view.R
import com.reouven.app_using_api_in_view.model.Number

class NumberAdapter(private val dataset: List<Number>) :
    RecyclerView.Adapter<NumberAdapter.NumberViewHolder>() {

    inner class NumberViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        val numberView: TextView = view.findViewById(R.id.numberView)
    }

    /**
     * Called when RecyclerView needs a new [NumberViewHolder] of the given type to represent
     * an item.
     *
     *
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     **
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     * an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return A new ViewHolder that holds a View of the given view type.
     * @see .getItemViewType
     * @see .onBindViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.itemnumber, parent, false)
        return NumberViewHolder(adapterLayout)
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount() = dataset.size

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the [NumberViewHolder.itemView] to reflect the item at the given
     * position.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     * item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        val item = dataset[position]
        //set text into TextView
        holder.numberView.text = item.number.toString()

        //set Background Color :
        // if flag of the number true : Red
        // if flag of the number false : Orange
        holder.numberView.setBackgroundColor(
            Color.parseColor(if (item.flag) "#FF0000" else "#FF7F00")
        )
        //set Background Color :
        // if flag of the number true : 300  (~= 150 dp)
        // if flag of the number false : 150 (~= 100 dp)
        holder.numberView.layoutParams.height = if (item.flag) 300 else 150
    }
}