package com.garvardinho.nwcode.view.detail

import com.squareup.picasso.RequestCreator
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface DetailView : MvpView {

    fun showPhoto(picasso: RequestCreator)
    fun setPhotoUrl()
}
