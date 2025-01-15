import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.connectfirebase.MahasiswaApplications
import com.example.connectfirebase.ui.viewmodel.DetailVIewModel
import com.example.connectfirebase.ui.viewmodel.HomeViewModel
import com.example.connectfirebase.ui.viewmodel.InsertViewModel


object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(
                mahasiswaApplications().container.mahasiswaRepository
            )
        }
        initializer {
            InsertViewModel(
                mahasiswaApplications().container.mahasiswaRepository
            )
        }
        initializer {
            DetailVIewModel(
                createSavedStateHandle(),
                mahasiswaApplications().container.mahasiswaRepository
            )
        }
    }
}

fun CreationExtras.mahasiswaApplications(): MahasiswaApplications =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MahasiswaApplications)