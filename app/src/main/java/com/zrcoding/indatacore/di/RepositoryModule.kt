package com.zrcoding.indatacore.di

import com.zrcoding.indatacore.data.repository.ProductRepository
import com.zrcoding.indatacore.data.repository.ProductRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun providePostRepository(
        productRepositoryImpl: ProductRepositoryImpl
    ): ProductRepository
}