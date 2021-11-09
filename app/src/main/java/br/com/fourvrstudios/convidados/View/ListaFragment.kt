package br.com.fourvrstudios.convidados.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.fourvrstudios.convidados.MyViewModel
import br.com.fourvrstudios.convidados.R
import br.com.fourvrstudios.convidados.ViewModelFactory
import br.com.fourvrstudios.convidados.databinding.FragmentListaBinding
import br.com.fourvrstudios.convidados.db.MyDatabase
import br.com.fourvrstudios.convidados.db.Repositorio

class ListaFragment : Fragment() {
    private lateinit var binding: FragmentListaBinding
    lateinit var viewModel: MyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_lista, container, false)

        val dao = MyDatabase.getInstance(requireContext()).convidadoDAO
        val repositorio = Repositorio(dao)
        val factory = ViewModelFactory(repositorio)

        viewModel = ViewModelProvider(requireActivity(), factory).get(MyViewModel::class.java)

        viewModel.convidados.observe(viewLifecycleOwner, Observer{
            var strListaConvidados = ""
            var somaConvidados = 0
            it.forEach{
                somaConvidados ++
                strListaConvidados += "${somaConvidados.toString()} - ${it.name} - ${it.email} \n"
            }

            binding.textView.text = strListaConvidados
        })

        binding.viewModelList = viewModel

        return binding.root
    }
}