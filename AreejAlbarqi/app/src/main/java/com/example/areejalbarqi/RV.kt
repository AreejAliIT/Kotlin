package com.example.areejalbarqi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


    class Equations(private val context: Context, private val equations:ArrayList<String>) :
        RecyclerView.Adapter<Equations.ViewHolder>(){

        class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView)
        // for binding
        private lateinit var tvRV : TextView

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                LayoutInflater.from(context).inflate(
                    R.layout.item_row,
                    parent,
                    false
                )
            )
        }
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            var msg = equations[position]
            holder.itemView.apply {
                // for binding
                tvRV = findViewById(R.id.tvRV)
                tvRV.text = msg
            }
        }
        override fun getItemCount() = equations.size
    }
