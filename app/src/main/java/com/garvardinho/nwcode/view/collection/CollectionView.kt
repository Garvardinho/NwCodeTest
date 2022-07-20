package com.garvardinho.nwcode.view.collection

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface CollectionView: MvpView {

    fun setCollectionCategory()
    fun showPhotos()
}
