package com.hitg.pokeapiconsumer.ui.search

import com.hitg.pokeapiconsumer.data.network.APIService
import com.hitg.pokeapiconsumer.model.Pokemon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonSearchPresenter(var view: PokemonSearchContract.View) :
    PokemonSearchContract.Presenter {
    override fun search(pokemon: String) {
        if (pokemon.isEmpty()) {
            view.showError("Pesquise pelo nome ou ID")
        } else {
            view.showLoading()
            APIService.instance
                ?.search(pokemon)
                ?.enqueue(object : Callback<Pokemon> {
                    override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                        view.hideLoading()
                        if (response.isSuccessful) {
                            view.showPokemon(response.body())
                        } else {
                            view.showError("Pokemon não encontrado")
                        }
                    }

                    override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                        view.hideLoading()
                        view.showError(t.message.toString())
                    }
                })
        }
    }
}