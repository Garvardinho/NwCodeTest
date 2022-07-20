package com.garvardinho.nwcode.view.collection

import com.garvardinho.nwcode.model.retrofit.PhotoDTO
import com.garvardinho.nwcode.view.NwItemView

interface CollectionImageView : NwItemView {

    fun setImage(image: PhotoDTO)
}