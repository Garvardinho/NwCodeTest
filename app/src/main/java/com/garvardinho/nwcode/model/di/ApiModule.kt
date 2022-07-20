package com.garvardinho.nwcode.model.di

import android.content.Context
import com.garvardinho.nwcode.model.retrofit.UnsplashAPI
import com.garvardinho.nwcode.utils.AndroidNetworkStatus
import com.garvardinho.nwcode.utils.INetworkStatus
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {

    @Named("baseUrl")
    @Provides
    fun baseUrl(): String = "https://api.unsplash.com/"

    @Named("apiKey")
    @Provides
    fun apiKey(): String = "DUPJ2ESjxb-1ZjZGTqcxhzlpmCj_c18XHRyy0GKOihg"

    @Singleton
    @Provides
    fun gson(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun api(
        @Named("baseUrl") baseUrl: String,
        gson: Gson,
    ): UnsplashAPI = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
        .create(UnsplashAPI::class.java)

    @Provides
    @Singleton
    fun networkStatus(context: Context): INetworkStatus =
        AndroidNetworkStatus(context)
}