package com.generation.todolist.api

import com.generation.todolist.Model.Categoria
import com.generation.todolist.Model.Tarefa
import retrofit2.Response

class Repository {

    suspend fun listCategoria(): Response<List<Categoria>>{
        return RetrofitInstance.api.listCategoria()
    }

    suspend fun addTarefa(tarefa: Tarefa) : Response<Tarefa>{
        return RetrofitInstance.api.addTarefa(tarefa)
    }
}