package com.garvardinho.nwcode.view.screens

import com.garvardinho.nwcode.view.category.CategoryFragment
import com.garvardinho.nwcode.view.collection.CollectionFragment
import com.garvardinho.nwcode.view.detail.DetailFragment
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen


class Screens : IScreens {
    override fun categoryScreen(): Screen {
        return FragmentScreen { CategoryFragment() }
    }

    override fun collectionScreen(category: String): Screen {
        return FragmentScreen { CollectionFragment.newInstance(category) }
    }

    override fun detailScreen(url: String): Screen {
        return FragmentScreen { DetailFragment.newInstance(url) }
    }
}