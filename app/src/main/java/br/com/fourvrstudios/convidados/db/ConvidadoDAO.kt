package br.com.fourvrstudios.convidados.db

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

// DAO - Data Access Object
@Dao
interface ConvidadoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserirConvidado(convidado: Convidado)

    @Update
    suspend fun updateConvidado(convidado: Convidado)

    @Delete
    suspend fun deleteConvidado(convidado: Convidado)

    @Query("SELECT * FROM CONVIDADO_DATA_TABLE")
    fun listarConvidados(): LiveData<List<Convidado>>

    @Query("DELETE FROM CONVIDADO_DATA_TABLE")
    suspend fun deleteAll()

    @Query("SELECT * FROM CONVIDADO_DATA_TABLE WHERE CONVIDADO_NAME LIKE '%' || :search || '%'")
    suspend fun buscarConvidado(search: String): Convidado?

    @Query("SELECT * FROM CONVIDADO_DATA_TABLE ORDER BY _id DESC")
    fun listarConvidadosDesc(): LiveData<List<Convidado>>

    @Query("SELECT * FROM CONVIDADO_DATA_TABLE ORDER BY convidado_name ASC")
    fun listarConvidadosAsc(): Flow<List<Convidado>>

    @Query("SELECT * FROM CONVIDADO_DATA_TABLE ORDER BY _id DESC LIMIT 1")
    fun getUltimoConvidado(): Convidado?
}