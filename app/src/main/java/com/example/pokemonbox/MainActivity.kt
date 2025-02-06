package com.example.pokemonbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.common.base_component.BaseActivity
import com.example.pokemonlist.presentation.PokemonListActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutInflater.inflate(R.layout.activity_main, binding.contentFrame);
        init();
    }

    fun init(){
        startActivity(Intent(this, PokemonListActivity::class.java))
    }
}