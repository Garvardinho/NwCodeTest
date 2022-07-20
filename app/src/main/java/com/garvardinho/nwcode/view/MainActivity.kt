package com.garvardinho.nwcode.view

import android.os.Bundle
import com.garvardinho.nwcode.App
import com.garvardinho.nwcode.R
import com.garvardinho.nwcode.databinding.ActivityMainBinding
import com.garvardinho.nwcode.view.screens.IScreens
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity() {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screens: IScreens

    private lateinit var mainActivityBinding: ActivityMainBinding
    private val navigator = AppNavigator(this, R.id.main_fragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        App.instance.appComponent.inject(this)

        setContentView(mainActivityBinding.root)
        router.navigateTo(screens.categoryScreen())
        supportActionBar?.hide()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }
}