package com.garvardinho.nwcode.presenter.collection

import com.garvardinho.nwcode.presenter.RecyclerViewPresenter
import com.garvardinho.nwcode.view.collection.CollectionImageView

class CollectionImageViewPresenter(private val presenter: CollectionPresenter)
    : RecyclerViewPresenter<CollectionImageView>{

    private val urls = mutableListOf<String>()

    override fun bindView(view: CollectionImageView) {
        view.setImageFromUrl(urls[view.pos])
    }

    override fun getCount(): Int = urls.size

    override fun onClick(pos: Int) {
        presenter.onImageClick(urls[pos])
    }

    fun addAllUrls(urls: List<String>) {
        this.urls.addAll(urls)
    }
}
