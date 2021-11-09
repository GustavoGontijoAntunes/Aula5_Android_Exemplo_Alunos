package br.com.fourvrstudios.convidados.db

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//Repositório: uma classe criada para gerenciar várias fontes de dados.
class Repositorio(private val dao: ConvidadoDAO) {
//Somente o DAO precisa ser passado ao construtor do repositório (não é necessário expor o banco de dados)já que ele contém todos os métodos de leitura/gravação do BD.

    val listaConvidados = dao.listarConvidados()

    suspend fun insert(convidado: Convidado){
        dao.inserirConvidado(convidado)
    }

    suspend fun update(convidado: Convidado){
        dao.updateConvidado(convidado)
    }

    suspend fun delete(convidado: Convidado){
        dao.deleteConvidado(convidado)
    }

    suspend fun clearAll(){
        dao.deleteAll()
    }

    suspend fun selectConvidado(busca: String) : Convidado?{
        return withContext(Dispatchers.IO){
            return@withContext dao.buscarConvidado(busca)
        }
    }
}