package com.garvardinho.nwcode.model.retrofit

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CollectionDTO(
    var id: String? = null,
    var title: String? = null
) : Parcelable
