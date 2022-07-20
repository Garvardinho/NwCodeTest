package com.garvardinho.nwcode.model.di

import com.garvardinho.nwcode.model.repository.IRepository
import com.garvardinho.nwcode.model.repository.Repository
import com.garvardinho.nwcode.model.retrofit.DataSource
import com.garvardinho.nwcode.model.retrofit.IDataSource
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun dataSource(impl: DataSource): IDataSource

    @Singleton
    @Binds
    abstract fun repository(impl: Repository): IRepository
}