package com.garvardinho.nwcode.model.retrofit

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface UnsplashAPI {

    @GET("collections")
    fun loadCategories(
        @Query("client_id") key: String
    ) : Single<List<CollectionDTO>>

    @GET
    fun loadCollection(
        @Url url: String,
        @Query("client_id") key: String,
        @Query("page") page: Int = 1,
    ) : Single<List<PhotoDTO>>
}