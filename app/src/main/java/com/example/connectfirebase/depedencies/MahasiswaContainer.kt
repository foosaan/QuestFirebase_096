package com.example.connectfirebase.depedencies

import MahasiswaRepository
import com.example.connectfirebase.repository.NetworkMahasiswaRespository
import com.google.firebase.firestore.FirebaseFirestore


interface AppContainer {
    val mahasiswaRepository: MahasiswaRepository
}

class MahasiswaContainer: AppContainer {
    private val firestore : FirebaseFirestore = FirebaseFirestore.getInstance() //Setara dengan url di remote db
    override val mahasiswaRepository: MahasiswaRepository by lazy {
        NetworkMahasiswaRespository(firestore)
    }
}