package com.garvardinho.nwcode.presenter.collection

import com.garvardinho.nwcode.model.retrofit.PhotoDTO
import com.garvardinho.nwcode.presenter.RecyclerViewPresenter
import com.garvardinho.nwcode.view.collection.CollectionImageView

class CollectionImageViewPresenter(private val presenter: CollectionPresenter)
    : RecyclerViewPresenter<CollectionImageView>{

    private val photos = mutableListOf<PhotoDTO>()

    override fun bindView(view: CollectionImageView) {
        view.setImage(photos[view.pos])
    }

    override fun getCount(): Int = photos.size

    override fun onClick(pos: Int) {
        presenter.onImageClick(photos[pos])
    }

    fun addPhoto(photo: PhotoDTO) {
        this.photos.add(photo)
    }
}
