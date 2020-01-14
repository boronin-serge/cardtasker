package ru.boronin.cardtasker

import android.app.Application
import ru.boronin.cardtasker.features.main.di.app.AppComponent
import ru.boronin.cardtasker.features.main.di.app.DaggerAppComponent

/**
 * Created by Sergey Boronin on 19.12.2019.
 */
open class App : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}