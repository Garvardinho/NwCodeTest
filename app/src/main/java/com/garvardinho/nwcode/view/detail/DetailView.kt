package com.garvardinho.nwcode.view.detail

import com.garvardinho.nwcode.view.NwView
import com.squareup.picasso.RequestCreator
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface DetailView : MvpView, NwView {

    fun showPhoto(picasso: RequestCreator)
    fun setPhotoUrl()
}
