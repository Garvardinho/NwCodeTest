package com.garvardinho.nwcode.view.collection

import com.garvardinho.nwcode.view.NwView
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface CollectionView: MvpView, NwView {

    fun setCollectionCategory()
    fun showPhotos()
}
