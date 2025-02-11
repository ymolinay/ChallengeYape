package com.yape.challengeyape.di

import com.yape.data.remote.ApiService
import com.yape.data.remote.RetrofitInstance
import com.yape.data.repository.DataRepositoryImpl
import com.yape.domain.repository.DataRepository
import com.yape.domain.usecase.GetDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService = RetrofitInstance.api

    @Provides
    @Singleton
    fun provideDataRepository(apiService: ApiService): DataRepository {
        return DataRepositoryImpl(apiService)
    }

    @Provides
    fun provideGetDataUseCase(repository: DataRepository): GetDataUseCase {
        return GetDataUseCase(repository)
    }
}