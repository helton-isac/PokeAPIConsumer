package com.hitg.pokeapiconsumer.data.network

import com.hitg.pokeapiconsumer.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiService {
    @GET("/api/v2/pokemon/{pokemon}")
    fun search(@Path("pokemon") pokemon: String): Call<Pokemon>
}