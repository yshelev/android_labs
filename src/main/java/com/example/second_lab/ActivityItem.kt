package com.example.second_lab

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

enum class ActivityType(val displayName: String) {
    RUNNING("Бег"),
    BICYCLE("Велосипед"),
    WALKING("Шаг")
}

@Entity(tableName = "activity_items")
data class ActivityItem(
    val user: String,
    val type: ActivityType,
    val startTime: Long = System.currentTimeMillis(),
    val endTime: Long = System.currentTimeMillis() + 500000,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
) : Serializable