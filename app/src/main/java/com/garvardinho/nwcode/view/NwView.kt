package com.garvardinho.nwcode.view

import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface NwView {

    fun showError(message: String)
}
