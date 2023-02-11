package ru.myitschool.lab23

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val list: List<Person>) : RecyclerView.Adapter<MyAdapter.MyItem>() {

    class MyItem(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyItem {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyItem(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MyItem, position: Int) {
        holder.name.text = list.get(position).name
    }

}