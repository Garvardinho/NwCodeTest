package com.garvardinho.nwcode.model.retrofit

import io.reactivex.rxjava3.core.Single

interface IDataSource {

    fun loadCategories(): Single<List<CollectionDTO>>
    fun loadCollection(category: CollectionDTO): Single<List<PhotoDTO>>
}