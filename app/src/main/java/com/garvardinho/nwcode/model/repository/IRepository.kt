package com.garvardinho.nwcode.model.repository

import com.garvardinho.nwcode.model.retrofit.CollectionDTO
import com.garvardinho.nwcode.model.retrofit.PhotoDTO
import io.reactivex.rxjava3.core.Single

interface IRepository {
    fun loadCategories(): Single<List<CollectionDTO>>
    fun loadCollection(category: CollectionDTO): Single<List<PhotoDTO>>
}