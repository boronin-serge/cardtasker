package ru.boronin.cardtasker.features.main.di.activity

import androidx.fragment.app.FragmentActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import ru.boronin.cardtasker.features.details.di.DetailsComponent
import ru.boronin.cardtasker.features.details.ui.DetailsFragment
import ru.boronin.cardtasker.features.home.di.HomeComponent
import ru.boronin.cardtasker.features.main.ui.MainActivity
import ru.boronin.cardtasker.features.onboarding.di.OnboardingComponent
import ru.boronin.cardtasker.features.tasks.di.TasksComponent

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

    fun detailsFactory(): DetailsComponent.Factory
    fun homeFactory(): HomeComponent.Factory
    fun tasksFactory(): TasksComponent.Factory
    fun onboardingFactory(): OnboardingComponent.Factory

    fun inject(activity: MainActivity)
}