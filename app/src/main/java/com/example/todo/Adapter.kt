package com.example.todo

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view.view.*
import java.util.*

class Adapter(var data: List<model>) : RecyclerView.Adapter<Adapter.viewHolder>() {



    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.title
        var layout = itemView.mylayout
        var pr = itemView.priority

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.view, parent, false)
        return viewHolder(itemView)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        when (data[position].priority) {
            0 -> {
                holder.layout.setBackgroundColor(Color.parseColor("#F05454"))
                holder.pr.text = "High"
            }
            1 -> {
                holder.layout.setBackgroundColor(Color.parseColor("#EDC988"))
                holder.pr.text = "Medium"
            }
            else -> {
                holder.layout.setBackgroundColor(Color.parseColor("#4CAF50"))
                holder.pr.text = "Low"
            }
        }

        holder.title.text = data[position].title
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, UpdateCard::class.java)
            intent.putExtra("id", position)
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }
}