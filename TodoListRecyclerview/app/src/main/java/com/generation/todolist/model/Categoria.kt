package com.generation.todolist.Model

data class Categoria
    (
    var id: Long,
    var descricao: String?,
    var tarefas: List<Tarefa>?
        ){

    override fun toString(): String {
        return descricao!! //Não pode ser nulo
    }
}