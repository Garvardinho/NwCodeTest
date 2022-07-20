package com.garvardinho.nwcode.presenter.detail

import com.garvardinho.nwcode.model.retrofit.PhotoDTO
import com.garvardinho.nwcode.view.detail.DetailView
import com.squareup.picasso.Picasso
import moxy.MvpPresenter

class DetailPresenter : MvpPresenter<DetailView>() {

    fun loadBigPhoto(photo: PhotoDTO) {
        viewState.showPhoto(Picasso.get().load(photo.urls?.full))
    }
}
