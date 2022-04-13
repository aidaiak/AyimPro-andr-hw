package com.aid.ayimpro_andr_hw.api

import com.aid.ayimpro_andr_hw.Item
import com.aid.ayimpro_andr_hw.Response
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyApi {

    @GET("characters")
    fun getCharacters(): Observable<Response>

    @GET("characters/{id}")
    fun getCharacter(@Path("id") id: Long): Observable<Item>
}