package ru.boronin.cardtasker.features.main.di.app

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.boronin.cardtasker.features.main.di.activity.ActivityComponent
import javax.inject.Singleton

/**
 * Created by Sergey Boronin on 14.01.2020.
 */

@Singleton
@Component(modules = [AppSubcomponents::class])
interface AppComponent {

    fun activityFactory(): ActivityComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}