package com.example.feature.home.di

import com.example.feature.home.data.PokemonRepositoryImpl
import com.example.feature.home.data.data_source.PokemonDataSourceRemote
import com.example.feature.home.data.remote.PokemonDataSourceRemoteImpl
import com.example.feature.home.data.remote.api.PokemonService
import com.example.feature.home.domain.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class HomeModule {

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

    @Provides
    @Singleton
    fun providePokemonService(retrofit: Retrofit): PokemonService {
        return retrofit.create(PokemonService::class.java)
    }


}