package com.garvardinho.nwcode.view.category

import com.garvardinho.nwcode.view.NwView
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface CategoryView : MvpView, NwView {

    fun showCategories()
}
