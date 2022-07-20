package com.garvardinho.nwcode.presenter.category

import com.garvardinho.nwcode.model.repository.IRepository
import com.garvardinho.nwcode.model.retrofit.CollectionDTO
import com.garvardinho.nwcode.utils.INetworkStatus
import com.garvardinho.nwcode.view.category.CategoryView
import com.garvardinho.nwcode.view.screens.IScreens
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpPresenter
import javax.inject.Inject

class CategoryPresenter : MvpPresenter<CategoryView>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screens: IScreens

    @Inject
    lateinit var repository: IRepository

    @Inject
    lateinit var networkStatus: INetworkStatus

    val textViewPresenter = CategoryTextViewPresenter(this)

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadCategories()
    }

    private fun loadCategories() {
        networkStatus.isOnline()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
            { isOnline ->
                if (isOnline) {
                    repository.loadCategories()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                            { data ->
                                textViewPresenter.addCategories(data)
                                viewState.showCategories()
                            },
                            {
                                viewState.showError("Something went wrong!")
                            })
                } else {
                    viewState.showError("Check your Internet connection!")
                }
            }
    }

    fun onCategoryClick(category: CollectionDTO) {
        router.navigateTo(screens.collectionScreen(category))
    }
}