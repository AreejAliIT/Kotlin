package com.example.recyclerviewapp

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ActivityAdapter(private val context: Context, val activities: ArrayList<String>):
    RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder>() {

    class ActivityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private lateinit var activityText :TextView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        return ActivityViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        val activity = activities[position]
        holder.itemView.apply {
            activityText = findViewById(R.id.activityText)
            activityText.text = activity
        }
    }

    override fun getItemCount() = activities.size
}
