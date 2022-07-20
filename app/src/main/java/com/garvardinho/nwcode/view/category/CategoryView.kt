package com.garvardinho.nwcode.view.category

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface CategoryView : MvpView {

    fun showCategories()
}
