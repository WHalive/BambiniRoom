package com.example.bambini.app

import android.app.Application
import com.example.bambinifashion.database.BambiniDatabase

class BambiniFashionApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        BambiniDatabase.createInstance(this)
    }
}