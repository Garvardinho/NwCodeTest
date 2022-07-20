package com.garvardinho.nwcode.view

import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface NwView {

    fun setContentVisible(visibility: Boolean)
    fun showError(message: String)
}
