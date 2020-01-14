package ru.boronin.cardtasker.features.main.di.activity

import androidx.fragment.app.FragmentActivity
import dagger.BindsInstance
import dagger.Subcomponent
import ru.boronin.cardtasker.features.main.ui.MainActivity

/**
 * Created by Sergey Boronin on 14.01.2020.
 */

@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance activity: FragmentActivity,
            @BindsInstance containerId: Int
        ): ActivityComponent
    }

    fun inject(activity: MainActivity)
}