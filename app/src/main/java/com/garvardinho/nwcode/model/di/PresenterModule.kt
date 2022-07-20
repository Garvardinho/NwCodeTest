package com.garvardinho.nwcode.model.di

import com.garvardinho.nwcode.presenter.RecyclerViewPresenter
import com.garvardinho.nwcode.presenter.category.CategoryTextViewPresenter
import com.garvardinho.nwcode.presenter.collection.CollectionImageViewPresenter
import com.garvardinho.nwcode.view.category.CategoryTextItemView
import com.garvardinho.nwcode.view.collection.CollectionImageView
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class PresenterModule {

    @Singleton
    @Binds
    abstract fun categoryTextViewPresenter(presenter: CategoryTextViewPresenter):
            RecyclerViewPresenter<CategoryTextItemView>

    @Singleton
    @Binds
    abstract fun collectionImageViewPresenter(presenter: CollectionImageViewPresenter):
            RecyclerViewPresenter<CollectionImageView>
}