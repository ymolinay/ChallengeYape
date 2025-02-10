package com.yape.challengeyape.di

import com.yape.data.remote.ApiService
import com.yape.data.repository.DataRepositoryImpl
import com.yape.domain.repository.DataRepository
import com.yape.domain.usecase.GetDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://2782e730-dbaf-414a-8426-bc759689516f.mock.pstmn.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideDataRepository(apiService: ApiService): DataRepository {
        return DataRepositoryImpl(apiService)
    }

    @Provides
    fun provideGetDataUseCase(repository: DataRepository): GetDataUseCase {
        return GetDataUseCase(repository)
    }
}