package com.example.second_lab

import androidx.room.TypeConverter
import kotlin.collections.first

class ActivityTypeConverter {
    @TypeConverter
    fun fromActivityType(type: ActivityType): String {
        return type.displayName
    }

    @TypeConverter
    fun toActivityType(displayName: String): ActivityType {
        return ActivityType.entries.first { it.displayName == displayName }
    }
}