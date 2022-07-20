package com.garvardinho.nwcode.presenter.collection

import com.garvardinho.nwcode.view.collection.CollectionView
import com.garvardinho.nwcode.view.screens.IScreens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class CollectionPresenter : MvpPresenter<CollectionView>() {
    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screens: IScreens

    val imageViewPresenter = CollectionImageViewPresenter(this)

    fun loadUrls(category: String) {
        // data loading by category
        imageViewPresenter.addAllUrls(mutableListOf("asd", "qwe", "zxc", "ert"))
        viewState.showPhotos()
    }

    fun onImageClick(url: String) {
        router.navigateTo(screens.detailScreen(url))
    }
}
