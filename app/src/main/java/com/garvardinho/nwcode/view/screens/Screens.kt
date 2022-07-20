package com.garvardinho.nwcode.view.screens

import com.garvardinho.nwcode.model.retrofit.CollectionDTO
import com.garvardinho.nwcode.model.retrofit.PhotoDTO
import com.garvardinho.nwcode.view.category.CategoryFragment
import com.garvardinho.nwcode.view.collection.CollectionFragment
import com.garvardinho.nwcode.view.detail.DetailFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen


class Screens : IScreens {
    override fun categoryScreen(): Screen {
        return FragmentScreen { CategoryFragment() }
    }

    override fun collectionScreen(category: CollectionDTO): Screen {
        return FragmentScreen { CollectionFragment.newInstance(category) }
    }

    override fun detailScreen(photo: PhotoDTO): Screen {
        return FragmentScreen { DetailFragment.newInstance(photo) }
    }
}