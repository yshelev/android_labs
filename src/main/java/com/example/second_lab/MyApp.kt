package com.example.second_lab

import android.app.Application

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Deps.context = applicationContext
        Deps.initDatabase()
    }
}