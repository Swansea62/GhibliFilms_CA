package com.example.ghiblifilms_ca

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ghiblifilms_ca.data.GhibliEntity

class MainViewModel : ViewModel() {
    val filmsList = MutableLiveData<List<GhibliEntity>>()

    init {
        filmsList.value = SampleDataProvider.getFilms()
    }
}