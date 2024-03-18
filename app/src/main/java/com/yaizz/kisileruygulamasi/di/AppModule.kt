package com.yaizz.kisileruygulamasi.di

import com.yaizz.kisileruygulamasi.data.datasource.KisilerDataSource
import com.yaizz.kisileruygulamasi.data.repo.KisilerRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {


    @Singleton
    @Provides

    fun provideKisilerDataSource() : KisilerDataSource{
        return KisilerDataSource()
    }


    @Singleton
    @Provides
    fun provideKisilerRepository(kds : KisilerDataSource) : KisilerRepository{
        return KisilerRepository(kds)
    }
}