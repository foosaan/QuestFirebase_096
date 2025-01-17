package com.example.connectfirebase.depedencies

import MahasiswaRepository
import com.example.connectfirebase.repository.NetworkMahasiswaRepository
import com.google.firebase.firestore.FirebaseFirestore


// interface AppContainer untuk menyediakan akses ke MahasiswaRepository.
interface AppContainer {
    val mahasiswaRepository: MahasiswaRepository
}

class MahasiswaContainer: AppContainer {
    private val firestore : FirebaseFirestore = FirebaseFirestore.getInstance()
    override val mahasiswaRepository: MahasiswaRepository by lazy {
        NetworkMahasiswaRepository(firestore)
    }
}