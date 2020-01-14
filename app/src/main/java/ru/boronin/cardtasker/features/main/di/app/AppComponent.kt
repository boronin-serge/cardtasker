package ru.boronin.cardtasker.features.main.di.app

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.boronin.cardtasker.features.main.di.activity.ActivityComponent

/**
 * Created by Sergey Boronin on 14.01.2020.
 */

@Component(modules = [AppSubcomponents::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun activityComponent(): ActivityComponent.Factory
}