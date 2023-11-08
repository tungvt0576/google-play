package com.example.googleplaystore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HorizontalItemAdapter(val items: ArrayList<HorizontalModel>) :
    RecyclerView.Adapter<HorizontalItemAdapter.HorizontalItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_horizontal_list, parent, false)
        return HorizontalItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: HorizontalItemViewHolder, position: Int) {
        val horizontalModel = items[position]
        holder.category.text = horizontalModel.category

        val linearLayout = holder.apps

        for (app in horizontalModel.app) {
            val itemView = LayoutInflater.from(linearLayout.context).inflate(R.layout.layout_image_item, linearLayout, false)

            val imageThumb = itemView.findViewById<ImageView>(R.id.image_thumb)
            val textCaption = itemView.findViewById<TextView>(R.id.text_caption)
            val star = itemView.findViewById<TextView>(R.id.star)

            imageThumb.setImageResource(app.imageThumb)
            textCaption.text = app.name
            star.text = app.star.toString()

            linearLayout.addView(itemView)
        }
    }

    class HorizontalItemViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val apps: LinearLayout
        val category: TextView

        init {
            apps = itemView.findViewById(R.id.layout_items)
            category = itemView.findViewById(R.id.category)
        }
    }
}