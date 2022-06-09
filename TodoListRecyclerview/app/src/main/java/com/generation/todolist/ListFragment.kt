package com.generation.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.generation.todolist.Adapter.TarefaAdapter
import com.generation.todolist.Model.Tarefa
import com.generation.todolist.databinding.FragmentFormBinding
import com.generation.todolist.databinding.FragmentListBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater, container, false)

        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val floatingAdd = view.findViewById<FloatingActionButton>(R.id.floatingAdd)

        val listTarefas = listOf(
            Tarefa(
                "Lavar a louça",
                "Lavar a louça do dia todo",
                "Henrique",
                "2022-05-15",
                false,
                "Dia a dia"
            ),
            Tarefa(
            "Ir ao Cinema",
            "Assistir Sonic 2",
            "Henrique",
            "2022-05-18",
            false,
            "Lazer"
            ),
            Tarefa(
            "Ir ao parque",
            "Visitar o parque Ibirapuera com os amigos",
            "Henrique",
            "2022-05-13",
            false,
            "Lazer"
            )
        )

        //Configuração do RecyclerView
        val adapter = TarefaAdapter()
        binding.recyclerTarefa.layoutManager = LinearLayoutManager(context)
        binding.recyclerTarefa.adapter = adapter
        binding.recyclerTarefa.setHasFixedSize(true)

        adapter.setList(listTarefas)

        binding.floatingAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_formFragment)
        }

        return binding.root
    }

}