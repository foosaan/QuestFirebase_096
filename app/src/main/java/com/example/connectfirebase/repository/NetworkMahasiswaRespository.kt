package com.example.connectfirebase.repository

import MahasiswaRepository
import com.example.connectfirebase.model.Mahasiswa
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class NetworkMahasiswaRespository( private val firestore: FirebaseFirestore ): MahasiswaRepository{

    override suspend fun getMahasiswa(): Flow<List<Mahasiswa>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertMahasiswa(mahasiswa: Mahasiswa) {
        TODO("Not yet implemented")
    }

    override suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteMahasiswa(nim: String) {
        TODO("Not yet implemented")
    }

    override suspend fun getMahasiswaById(nim: String): Flow<Mahasiswa> {
        TODO("Not yet implemented")
    }


}