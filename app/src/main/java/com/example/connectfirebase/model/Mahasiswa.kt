package com.example.connectfirebase.model

data class Mahasiswa (
    val nim: String,
    val nama: String,
    val jenisKelamin: String,
    val alamat: String,
    val kelas: String,
    val angkatan: String,
    val judulSkripsi: String,
    val DosenPembimbing1: String,
    val DosenPembimbing2: String

) {
    constructor():this("", "", "", "", "", "","","","")
}