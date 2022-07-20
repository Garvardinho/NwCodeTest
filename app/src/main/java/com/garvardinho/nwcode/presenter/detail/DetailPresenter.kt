package com.garvardinho.nwcode.presenter.detail

import com.garvardinho.nwcode.model.retrofit.PhotoDTO
import com.garvardinho.nwcode.utils.INetworkStatus
import com.garvardinho.nwcode.view.detail.DetailView
import com.squareup.picasso.Picasso
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpPresenter
import javax.inject.Inject

class DetailPresenter : MvpPresenter<DetailView>() {

    @Inject
    lateinit var networkStatus: INetworkStatus

    fun loadBigPhoto(photo: PhotoDTO) {
        networkStatus.isOnline()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
            { isOnline ->
                if (isOnline) {
                    viewState.showPhoto(Picasso.get().load(photo.urls?.regular))
                } else {
                    viewState.showError("Check your Internet connection!")
                }
            }
    }
}
