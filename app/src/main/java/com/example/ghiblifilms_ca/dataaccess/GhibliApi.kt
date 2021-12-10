package com.example.ghiblifilms_ca.dataaccess

import com.example.ghiblifilms_ca.data.GhibliEntity
import retrofit2.Response
import retrofit2.http.GET

interface GhibliApi {

    @GET("films")
    suspend fun getFilms() : List<GhibliEntity>
}