package com.kotlinapp.autentia.animationlist.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlinapp.autentia.animationlist.Item
import com.kotlinapp.autentia.animationlist.R
import kotlinx.android.synthetic.main.item_list.view.*

/**
 * Proyecto com.kotlinapp.autentia.animationlist.adapter
 * Created by erubio on 8/11/17.
 */
class MyAdapter constructor(val data: ArrayList<Item>, val listener: (Item) -> Unit) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = data[position]
        holder.bind(data, listener)
    }

    class ViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.item_list)) {


        var _item = itemView.tvItem

        fun bind(item: Item,  listener: (Item) -> Unit) {

            _item.text = item.decripcion
            itemView.bt_delete.setOnClickListener{listener(item)}


        }

    }

    fun deleteItem(item: Item){
        data.removeAt(data.indexOf(item))
        notifyDataSetChanged()
    }

}

private  fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}