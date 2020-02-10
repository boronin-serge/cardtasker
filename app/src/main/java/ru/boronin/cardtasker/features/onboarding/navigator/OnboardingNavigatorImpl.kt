package ru.boronin.cardtasker.features.onboarding.navigator

import ru.boronin.cardtasker.features.home.ui.HomeFragment
import ru.boronin.common.navigation.AppNavigator

class OnboardingNavigatorImpl  : AppNavigator(), OnboardingNavigator {
    override fun openHome() {
        globalHandler?.setRoot(HomeFragment())
    }
}