package com.garvardinho.nwcode.model.di

import com.garvardinho.nwcode.presenter.category.CategoryPresenter
import com.garvardinho.nwcode.presenter.collection.CollectionPresenter
import com.garvardinho.nwcode.view.MainActivity
import com.garvardinho.nwcode.view.category.CategoryAdapter
import com.garvardinho.nwcode.view.collection.CollectionAdapter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CiceroneModule::class,
        PresenterModule::class
    ]
)

interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(adapter: CategoryAdapter)
    fun inject(adapter: CollectionAdapter)
    fun inject(presenter: CategoryPresenter)
    fun inject(presenter: CollectionPresenter)
}