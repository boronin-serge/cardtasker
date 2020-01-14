package ru.boronin.cardtasker.features.details.di

import androidx.fragment.app.FragmentActivity
import dagger.BindsInstance
import dagger.Component
import ru.boronin.cardtasker.features.details.ui.DetailsFragment

/**
 * Created by Sergey Boronin on 14.01.2020.
 */

@Component(modules = [DetailsModule::class])
interface DetailsComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance activity: FragmentActivity,
            @BindsInstance containerId: Int
        ): DetailsComponent
    }

    fun inject(fragment: DetailsFragment)
}