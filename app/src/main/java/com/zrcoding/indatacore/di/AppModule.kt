package com.zrcoding.indatacore.di

import com.zrcoding.indatacore.data.sources.fake.FakeDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideFakeDataSource(): FakeDataSource = FakeDataSource()
}