package com.example.second_lab

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Room

object Deps {
    lateinit var context: Context
    lateinit var db: MyDatabase

    @SuppressLint("StaticFieldLeak")
    fun initDatabase() {
        db = Room.databaseBuilder(
            context,
            MyDatabase::class.java,
            "MyDB"
        ).fallbackToDestructiveMigration().build()
    }
}