package ru.boronin.cardtasker.features.home.di

import dagger.BindsInstance
import dagger.Subcomponent
import ru.boronin.cardtasker.features.home.ui.HomeFragment

/**
 * Created by Sergey Boronin on 30.01.2020.
 */

@Subcomponent(modules = [HomeModule::class])
interface HomeComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance fragment: HomeFragment): HomeComponent
    }

    fun inject(fragment: HomeFragment)
}