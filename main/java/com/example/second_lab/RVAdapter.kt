package com.example.second_lab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter : RecyclerView.Adapter<RVAdapter.ActivityViewHolder>() {

    private val activities = listOf(
        ActivityItem( "14.32 км", "2 часа 46 минут", "Серфинг", "14 часов назад"),
        ActivityItem( "1000 м", "60 минут", "Велосипед", "29.05.2022"),
        ActivityItem( "5.5 км", "45 минут", "Бег", "12.04.2022"),
        ActivityItem( "3.2 км", "30 минут", "Ходьба", "10.04.2022"),
        ActivityItem( "8.7 км", "1 час 15 минут", "Велосипед", "05.04.2022"),
        ActivityItem( "12.0 км", "2 часа", "Плавание", "01.04.2022"),
    )

    class ActivityViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val distance: TextView = view.findViewById(R.id.distance)
        val time: TextView = view.findViewById(R.id.time)
        val activityType: TextView = view.findViewById(R.id.activityType)
        val timestamp: TextView = view.findViewById(R.id.timestamp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ActivityViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        val activity = activities[position]
        holder.distance.text = activity.distance
        holder.time.text = activity.time
        holder.activityType.text = activity.activityType
        holder.timestamp.text = activity.timestamp
    }

    override fun getItemCount(): Int {
        return activities.size
    }
}