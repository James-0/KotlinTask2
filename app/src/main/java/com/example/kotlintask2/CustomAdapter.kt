package com.example.kotlintask2


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val itemList: ArrayList<Item>, onNoteListener: OnNoteListener) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    private var mOnNoteListener: OnNoteListener = onNoteListener

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: Item = itemList[position]

        holder?.textViewName?.text = item.name
        holder?.textViewDescription?.text = item.description
    }

    class ViewHolder(itemView: View, onNoteListener: OnNoteListener) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val textViewName = itemView.findViewById(R.id.name) as TextView
        val textViewDescription = itemView.findViewById(R.id.description) as TextView
        val obj = mutableListOf<OnNoteListener>()
        var onNoteListener: OnNoteListener? = null

        init {
            this.onNoteListener = onNoteListener
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            onNoteListener?.onNoteClick(adapterPosition)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.row_layout, parent, false)
        return ViewHolder(v, mOnNoteListener)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    interface OnNoteListener {
        fun onNoteClick(position: Int)
    }


}