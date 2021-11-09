package br.com.fourvrstudios.convidados.ATemplates

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.fourvrstudios.convidados.MyViewModel
import br.com.fourvrstudios.convidados.db.Repositorio
import java.lang.IllegalArgumentException

class MyViewModelFactory(private val repositorio: Repositorio) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MyViewModel::class.java)){
            return MyViewModel(repositorio) as T // Retorna a ViewModel
        }
        throw IllegalArgumentException("Unknown View Model class")
    }
}