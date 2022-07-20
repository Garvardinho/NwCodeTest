package com.garvardinho.nwcode.view.screens

import com.garvardinho.nwcode.model.retrofit.CollectionDTO
import com.garvardinho.nwcode.model.retrofit.PhotoDTO
import com.github.terrakok.cicerone.Screen

interface IScreens {

    fun categoryScreen(): Screen
    fun collectionScreen(category: CollectionDTO): Screen
    fun detailScreen(photo: PhotoDTO): Screen
}