package com.generation.todolist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.generation.todolist.Model.Categoria
import com.generation.todolist.api.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel : ViewModel() {

    val repository = Repository()
    private val _myCategoriaResponse =
        MutableLiveData<Response<List<Categoria>>>()

    val myCategoriaResponse: LiveData<Response<List<Categoria>>> =
        _myCategoriaResponse

    fun listCategoria(){
        viewModelScope.launch {
            _myCategoriaResponse.value = repository.listCategoria()
        }

    }
}