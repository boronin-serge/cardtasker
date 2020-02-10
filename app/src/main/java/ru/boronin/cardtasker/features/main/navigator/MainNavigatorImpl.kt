package ru.boronin.cardtasker.features.main.navigator

import ru.boronin.cardtasker.features.home.ui.HomeFragment
import ru.boronin.cardtasker.features.onboarding.ui.OnboardingFragment
import ru.boronin.common.navigation.AppNavigator

/**
 * Created by Sergey Boronin on 27.01.2020.
 */
class MainNavigatorImpl : AppNavigator(), MainNavigator {

    override fun openHome() {
        globalHandler?.open(HomeFragment())
    }

    override fun openOnboarding() {
        globalHandler?.open(OnboardingFragment())
    }
}