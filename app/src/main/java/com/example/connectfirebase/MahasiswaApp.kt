package com.example.connectfirebase

import android.app.Application
import com.example.connectfirebase.depedencies.AppContainer
import com.example.connectfirebase.depedencies.MahasiswaContainer

class MahasiswaApp : Application(){
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container=MahasiswaContainer()
    }
}