import com.example.connectfirebase.model.Mahasiswa
import kotlinx.coroutines.flow.Flow

interface MahasiswaRepository {

    suspend fun getMahasiswa(): Flow<List<Mahasiswa>>

    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)

    suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa)

    suspend fun deleteMahasiswa(nim: String)

    suspend fun getMahasiswaById(nim: String): Flow<Mahasiswa>
}