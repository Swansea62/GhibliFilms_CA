package com.example.ghiblifilms_ca

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ghiblifilms_ca.data.GhibliEntity
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _films: MutableLiveData<List<GhibliEntity>> = MutableLiveData()

    val films: LiveData<List<GhibliEntity>>

        get() = _films

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading


    init {
        getFilms()
    }

    private fun getFilms() {
        viewModelScope.launch {
            _isLoading.value = true
            val fetchedFilms = retrofitInstance.api.getFilms()
            Log.i(TAG, "List of films : $fetchedFilms")
            _films.value = fetchedFilms
            _isLoading.value = false
        }
    }

}