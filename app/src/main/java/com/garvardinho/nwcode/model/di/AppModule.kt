package com.garvardinho.nwcode.model.di

import com.garvardinho.nwcode.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {

    @Singleton
    @Provides
    fun app(): App {
        return app
    }
}