package ru.boronin.cardtasker.features.onboarding.di

import dagger.BindsInstance
import dagger.Subcomponent
import ru.boronin.cardtasker.features.onboarding.ui.OnboardingFragment

@Subcomponent(modules = [OnboardingModule::class])
interface OnboardingComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance fragment: OnboardingFragment): OnboardingComponent
    }

    fun inject(fragment: OnboardingFragment)
}
        
        
        