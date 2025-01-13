package com.example.connectfirebase

import android.app.Application
import com.example.connectfirebase.depedencies.AppContainer
import com.example.connectfirebase.depedencies.MahasiswaContainer

//   untuk inisialisasi mengatur komponen yang akan dipakai di seluruh aplikasi
class MahasiswaApplications: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container= MahasiswaContainer()
    }
}