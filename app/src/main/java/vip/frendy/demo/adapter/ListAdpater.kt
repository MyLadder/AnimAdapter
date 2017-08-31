package vip.frendy.demo.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_list.view.*
import vip.frendy.anim.AnimAdapter
import vip.frendy.demo.R

/**
 * Created by iiMedia on 2017/8/31.
 */
class ListAdpater(val list: ArrayList<String>, val itemClickListener: (String) -> Unit): AnimAdapter<ListAdpater.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view, itemClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(view: View, val itemClickListener: (String) -> Unit): RecyclerView.ViewHolder(view) {
        fun bind(item: String) {
            with(item) {
                itemView.text.text = item
                itemView.setOnClickListener { itemClickListener(this) }
            }
        }
    }
}