package com.example.pokemonbox.di

import com.example.data.pokemon.PokemonRepositoryImpl
import com.example.data.pokemon.data_source.PokemonDataSourceRemote
import com.example.data.pokemon.data_source_impl.remote.PokemonDataSourceRemoteImpl
import com.example.data.pokemon.data_source_impl.remote.api.PokemonService
import com.example.domain.pokemon.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun providesPokemonDataSourceRemote(pokemonService: PokemonService): PokemonDataSourceRemote {
        return PokemonDataSourceRemoteImpl(pokemonService)
    }

    @Provides
    @Singleton
    fun providesPokemonRepository(pokemonDataSourceRemote: PokemonDataSourceRemote): PokemonRepository {
        return PokemonRepositoryImpl(pokemonDataSourceRemote)
    }

}