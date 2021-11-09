package br.com.fourvrstudios.convidados.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
// CONFIGURAÇÃO DA TABELA E DE SUAS ENTIDADES.
// As colunas entram como variáveis do construtor.
@Entity(tableName = "convidado_data_table")
data class Convidado(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    var id: Int,
    @ColumnInfo(name = "convidado_name")
    var name: String,
    @ColumnInfo(name = "convidado_email")
    var email: String
){
}