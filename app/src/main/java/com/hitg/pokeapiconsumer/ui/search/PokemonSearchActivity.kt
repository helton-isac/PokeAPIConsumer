package com.hitg.pokeapiconsumer.ui.search

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hitg.pokeapiconsumer.R
import com.hitg.pokeapiconsumer.model.Pokemon
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_pokemon_search.*

class PokemonSearchActivity : AppCompatActivity(), PokemonSearchContract.View {

    private lateinit var presenter: PokemonSearchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_search)

        presenter = PokemonSearchPresenter(this)

        btSearch.setOnClickListener {
            presenter.search(etPokemonName.text.toString())
        }
    }

    override fun showPokemon(pokemon: Pokemon?) {
        Picasso.get().load(pokemon?.sprites?.front_default).into(ivPokemon);
    }

    override fun showError(mensagem: String) {
        Toast.makeText(
            this@PokemonSearchActivity,
            mensagem,
            Toast.LENGTH_SHORT
        ).show()/**/
    }

    override fun showLoading() {
        btSearch.isEnabled = false
        btSearch.text = "Loading..."
    }

    override fun hideLoading() {
        btSearch.isEnabled = true
        btSearch.text = "Pesquisar"
    }
}