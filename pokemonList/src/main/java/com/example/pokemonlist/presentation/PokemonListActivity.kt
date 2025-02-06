package com.example.pokemonlist.presentation

import android.os.Bundle
import com.example.common.base_component.BaseActivity
import com.example.pokemonlist.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PokemonListActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutInflater.inflate(R.layout.activity_pokemon_list, binding.contentFrame, true);

    }


}