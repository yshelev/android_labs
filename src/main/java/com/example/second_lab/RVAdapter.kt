package com.example.second_lab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class RVAdapter(private var activities: List<ActivityItem> = emptyList()) :
    RecyclerView.Adapter<RVAdapter.ActivityViewHolder>() {

    fun updateData(newActivities: List<ActivityItem>) {
        activities = newActivities
        notifyDataSetChanged()
    }

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
        holder.distance.text = "%.2f км".format(calculateDistance(activity))
        holder.time.text = formatDuration(activity.endTime - activity.startTime)
        holder.activityType.text = activity.type.displayName
        holder.timestamp.text = formatDate(activity.startTime)
    }

    override fun getItemCount(): Int {
        return activities.size
    }

    private fun calculateDistance(activity: ActivityItem): Double {
        val hours = (activity.endTime - activity.startTime).toDouble() / 3600000
        return when (activity.type) {
            ActivityType.RUNNING -> hours * 10
            ActivityType.BICYCLE -> hours * 20
            ActivityType.WALKING -> hours * 5
        }
    }

    private fun formatDuration(millis: Long): String {
        val seconds = millis / 1000
        val hours = seconds / 3600
        val minutes = (seconds % 3600) / 60
        return when {
            hours > 0 -> "$hours ч ${minutes} мин"
            else -> "$minutes мин"
        }
    }

    private fun formatDate(timestamp: Long): String {
        val sdf = SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault())
        return sdf.format(Date(timestamp))
    }
}