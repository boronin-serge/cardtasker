package ru.boronin.cardtasker.features.onboarding.di

import dagger.Module
import dagger.Provides
import ru.boronin.cardtasker.features.onboarding.navigator.OnboardingNavigator
import ru.boronin.cardtasker.features.onboarding.navigator.OnboardingNavigatorImpl
import ru.boronin.cardtasker.features.onboarding.ui.OnboardingFragment
import ru.boronin.common.navigation.AppNavigatorHandlerImpl
import ru.boronin.core.api.navigator.NavigatorHandler

@Module
class OnboardingModule {
    
    @Provides
    fun provideNavigator(
        navigatorHandler: NavigatorHandler,
        fragment: OnboardingFragment
    ): OnboardingNavigator {
        return OnboardingNavigatorImpl().apply {
            globalHandler = navigatorHandler
            localHandler = fragment.getLocalNavigator()
        }
    }
}