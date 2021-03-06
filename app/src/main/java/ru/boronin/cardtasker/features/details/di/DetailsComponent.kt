package ru.boronin.cardtasker.features.details.di

import dagger.BindsInstance
import dagger.Subcomponent
import ru.boronin.cardtasker.features.details.ui.DetailsFragment

/**
 * Created by Sergey Boronin on 14.01.2020.
 */

@Subcomponent(modules = [DetailsModule::class])
interface DetailsComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance fragment: DetailsFragment): DetailsComponent
    }

    fun inject(fragment: DetailsFragment)
}