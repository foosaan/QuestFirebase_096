package com.example.connectfirebase.ui.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.connectfirebase.model.Mahasiswa
import com.example.connectfirebase.ui.viewmodel.DetailUiState
import com.example.connectfirebase.ui.viewmodel.DetailVIewModel


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DetailView(
    navigateToItemUpdate: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailVIewModel
) {
    Scaffold { innerPadding ->
        DetailStatus(
            modifier = Modifier.padding(innerPadding),
            detailUiState = viewModel.mahasiswaDetailState,
            retryAction = { viewModel.getMahasiswabyNim() }
        )
    }
}

@Composable
fun DetailStatus(
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    detailUiState: DetailUiState
) {
    when (detailUiState) {
        is DetailUiState.Loading -> OnLoading(modifier = modifier.fillMaxSize())

        is DetailUiState.Success -> {
            val mahasiswa by detailUiState.mahasiswa.collectAsState(initial = null)
            if (mahasiswa != null) {
                ItemDetailMhs(mahasiswa = mahasiswa!!, modifier = modifier.fillMaxWidth())
            } else {
                Box(
                    modifier = modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Memuat data...")
                }
            }
        }

        DetailUiState.Error -> {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Terjadi kesalahan saat memuat data.")
                Button(onClick = retryAction) {
                    Text("Coba Lagi")
                }
            }
        }
    }
}

@Composable
fun ItemDetailMhs(
    modifier: Modifier = Modifier,
    mahasiswa: Mahasiswa
) {
    Card(
        modifier = modifier.padding(16.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            ComponentDetailMhs(judul = "NIM", isinya = mahasiswa.nim)
            ComponentDetailMhs(judul = "Nama", isinya = mahasiswa.nama)
            ComponentDetailMhs(judul = "Alamat", isinya = mahasiswa.alamat)
            ComponentDetailMhs(judul = "Jenis Kelamin", isinya = mahasiswa.jenisKelamin)
            ComponentDetailMhs(judul = "Kelas", isinya = mahasiswa.kelas)
            ComponentDetailMhs(judul = "Angkatan", isinya = mahasiswa.angkatan)
            ComponentDetailMhs(judul = "Judul", isinya = mahasiswa.judulSkripsi)
            ComponentDetailMhs(judul = "Dosen 1", isinya = mahasiswa.DosenPembimbing1)
            ComponentDetailMhs(judul = "Dosen 2", isinya = mahasiswa.DosenPembimbing2)
        }
    }
}

@Composable
fun ComponentDetailMhs(
    modifier: Modifier = Modifier,
    judul: String,
    isinya: String,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "$judul : ",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )
        Text(
            text = isinya,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}