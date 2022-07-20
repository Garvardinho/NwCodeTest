package com.garvardinho.nwcode.view.screens

import com.github.terrakok.cicerone.Screen

interface IScreens {

    fun categoryScreen(): Screen
    fun collectionScreen(category: String): Screen
    fun detailScreen(url: String): Screen
}