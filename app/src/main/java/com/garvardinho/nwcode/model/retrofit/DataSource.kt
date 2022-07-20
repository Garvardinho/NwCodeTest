package com.garvardinho.nwcode.model.retrofit

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Named

class DataSource @Inject constructor(
    private val api: UnsplashAPI
    ) : IDataSource {

    @Inject
    @Named("apiKey")
    lateinit var apiKey: String

    override fun loadCategories(): Single<List<CollectionDTO>> {
        return api.loadCategories(apiKey).subscribeOn(Schedulers.io())
    }

    override fun loadCollection(category: CollectionDTO): Single<List<PhotoDTO>> {
        return api.loadCollection("collections/${category.id.orEmpty()}/photos", apiKey).subscribeOn(Schedulers.io())
    }
}