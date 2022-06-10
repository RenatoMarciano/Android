package com.generation.todolist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.generation.todolist.Model.Categoria
import com.generation.todolist.api.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
        ) : ViewModel() {

    private val _myCategoriaResponse =
        MutableLiveData<Response<List<Categoria>>>()

    val myCotegoriaResponse: LiveData<Response<List<Categoria>>> =
        _myCategoriaResponse

    init {
        listCategoria()
    }

    fun listCategoria(){
        //Funcionando em segundo plano "viewModelScope.launch {}"
        viewModelScope.launch {
            try {
                val response = repository.listCategoria()
                _myCategoriaResponse.value = response
            }catch (e: Exception){
                Log.d("ErroRequisição", e.message.toString())
            }
        }

    }
}