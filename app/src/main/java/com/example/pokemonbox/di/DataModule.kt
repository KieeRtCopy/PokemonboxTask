package com.example.pokemonbox.di

import com.example.domain.pokemon.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

//    @Provides
//    fun providesPokemonRepository(): PokemonRepository {
//        return PokemonRepository()
//    }
}