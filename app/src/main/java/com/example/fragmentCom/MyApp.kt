package com.example.fragmentCom

import android.app.Application

class MyApp:Application() {
    override fun onCreate() {
        super.onCreate()
        Strings.init(this)
    }
}