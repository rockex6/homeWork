package com.rockex6.homework.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rockex6.homework.R
import com.rockex6.homework.databinding.ItemZooListBinding
import com.rockex6.homework.home.model.ZooListResult
import com.rockex6.homework.loadImage

class ZooListAdapter(private val data: MutableList<ZooListResult>) :
    RecyclerView.Adapter<ZooListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZooListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_zoo_list, parent, false)
        return ZooListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ZooListViewHolder, position: Int) {
        holder.vZooName.text = data[position].E_Name
        holder.vZooDescription.text = data[position].E_Info
        holder.vZooImg.loadImage(holder.vZooImg.context, data[position].E_Pic_URL)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}


class ZooListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = ItemZooListBinding.bind(itemView)
    val vZooImg: ImageView = binding.vZooImg
    val vZooName: TextView = binding.vZooName
    val vZooDescription: TextView = binding.vZooDescription
}