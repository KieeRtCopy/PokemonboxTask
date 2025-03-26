package com.example.feature.home.presentation.search

import android.os.Bundle
import com.example.common.base_component.BaseActivity
import com.example.feature.home.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PokemonListActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutInflater.inflate(R.layout.activity_pokemon_list, binding.contentFrame, true);

    }


}