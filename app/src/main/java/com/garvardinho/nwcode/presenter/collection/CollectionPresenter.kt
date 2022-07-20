package com.garvardinho.nwcode.presenter.collection

import com.garvardinho.nwcode.model.repository.IRepository
import com.garvardinho.nwcode.model.retrofit.CollectionDTO
import com.garvardinho.nwcode.model.retrofit.PhotoDTO
import com.garvardinho.nwcode.utils.INetworkStatus
import com.garvardinho.nwcode.view.collection.CollectionView
import com.garvardinho.nwcode.view.screens.IScreens
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpPresenter
import javax.inject.Inject

class CollectionPresenter : MvpPresenter<CollectionView>() {
    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screens: IScreens

    @Inject
    lateinit var repository: IRepository

    @Inject
    lateinit var networkStatus: INetworkStatus

    val imageViewPresenter = CollectionImageViewPresenter(this)

    fun loadUrls(category: CollectionDTO) {
        networkStatus.isOnlineSingle()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
            { isOnline ->
                if (isOnline) {
                    repository.loadCollection(category)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                            { data ->
                                for (photo in data) {
                                    imageViewPresenter.addPhoto(photo)
                                }
                                viewState.showPhotos()
                            },
                            {
                                viewState.showError("Something went wrong!")
                            })
                } else {
                    viewState.showError("Check your Internet connection!")
                }
            }
    }

    fun onImageClick(photo: PhotoDTO) {
        router.navigateTo(screens.detailScreen(photo))
    }
}
