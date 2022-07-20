package com.garvardinho.nwcode.model.repository

import com.garvardinho.nwcode.model.retrofit.CollectionDTO
import com.garvardinho.nwcode.model.retrofit.IDataSource
import com.garvardinho.nwcode.model.retrofit.PhotoDTO
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class Repository @Inject constructor(
    private val dataSource: IDataSource
) : IRepository {

    override fun loadCategories(): Single<List<CollectionDTO>> = dataSource.loadCategories()

    override fun loadCollection(category: CollectionDTO): Single<List<PhotoDTO>> =
        dataSource.loadCollection(category)
}