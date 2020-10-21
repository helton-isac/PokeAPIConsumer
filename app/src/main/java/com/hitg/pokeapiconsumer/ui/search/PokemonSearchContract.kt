package com.hitg.pokeapiconsumer.ui.search

import com.hitg.pokeapiconsumer.model.Pokemon

interface PokemonSearchContract {
    interface View {
        fun showPokemon(pokemon: Pokemon?)
        fun showError(mensagem: String)
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter {
        fun search(cep: String)
    }
}