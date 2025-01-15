package com.example.connectfirebase.ui.viewmodel

import MahasiswaRepository
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.connectfirebase.model.Mahasiswa
import com.example.connectfirebase.ui.view.DetailView
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.io.IOException


sealed class DetailUiState {
    data class Success(val mahasiswa: Flow<Mahasiswa>) : DetailUiState()
    object Error : DetailUiState()
    object Loading : DetailUiState()
}
class DetailVIewModel(
    savedStateHandle: SavedStateHandle,
    private val mhs: MahasiswaRepository
) : ViewModel() {

    var mahasiswaDetailState: DetailUiState by mutableStateOf(DetailUiState.Loading)
        private set

    private val _nim: String = checkNotNull(savedStateHandle[DetailView.nim])

    init {
        getMahasiswabyNim()
    }

    fun getMahasiswabyNim() {
        viewModelScope.launch {
            mahasiswaDetailState = DetailUiState.Loading
            mahasiswaDetailState = try {
                val Mahasiswa = mhs.getMahasiswabyNim(_nim)
                DetailUiState.Success(Mahasiswa)
            } catch (e: IOException) {
                DetailUiState.Error
            }
        }
    }
}