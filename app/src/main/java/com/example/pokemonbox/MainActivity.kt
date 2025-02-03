package com.example.pokemonbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.common.base_component.BaseActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutInflater.inflate(R.layout.activity_main, binding.contentFrame);
    }
}