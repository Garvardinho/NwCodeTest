package com.garvardinho.nwcode

import android.app.Application
import com.garvardinho.nwcode.model.di.AppComponent
import com.garvardinho.nwcode.model.di.AppModule
import com.garvardinho.nwcode.model.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    companion object {
        private const val ACCESS_KEY = "DUPJ2ESjxb-1ZjZGTqcxhzlpmCj_c18XHRyy0GKOihg"
        private const val SECRET_KEY = "HyLiv6DjzE61-zxPYVufAMeT_NNe0_49K741kmHpBlU"

        lateinit var instance: App
    }
}