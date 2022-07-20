package com.garvardinho.nwcode.presenter.category

import com.garvardinho.nwcode.view.category.CategoryView
import com.garvardinho.nwcode.view.screens.IScreens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class CategoryPresenter : MvpPresenter<CategoryView>() {

    @Inject
    lateinit var router: Router
    @Inject
    lateinit var screens: IScreens

    val textViewPresenter = CategoryTextViewPresenter(this)

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadCategories()
    }

    private fun loadCategories() {
        // Data loading things
        // viewState.showCategories()
        textViewPresenter.addCategories(listOf("qweqwe", "asdasd", "zxczxc", "eeeeee"))
        viewState.showCategories()
    }

    fun onCategoryClick(category: String) {
        router.navigateTo(screens.collectionScreen(category))
    }
}