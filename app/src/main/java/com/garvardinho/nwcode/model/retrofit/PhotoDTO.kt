package com.garvardinho.nwcode.model.retrofit

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PhotoDTO(
    var id: String? = null,
    var width: Int? = null,
    var height: Int? = null,
    var urls: PhotoUrls? = null
) : Parcelable {
    @Parcelize
    data class PhotoUrls(
        var regular: String? = null,
        var small: String? = null
    ) : Parcelable
}