package com.garvardinho.nwcode.presenter

import com.garvardinho.nwcode.view.NwItemView

interface RecyclerViewPresenter<V : NwItemView> {

    fun bindView(view: V)
    fun getCount(): Int
    fun onClick(pos: Int)
}
