package com.example.second_lab

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ActivityItemDao {
    @Insert
    suspend fun insert(activity: ActivityItem)

    @Delete
    suspend fun delete(activity: ActivityItem)

    @Update
    suspend fun update(activity: ActivityItem)

    @Query("SELECT * FROM activity_items")
    fun getAllActivities(): LiveData<List<ActivityItem>>
}