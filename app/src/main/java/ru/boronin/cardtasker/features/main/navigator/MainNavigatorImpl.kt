package ru.boronin.cardtasker.features.main.navigator

import ru.boronin.cardtasker.features.details.ui.DetailsFragment
import ru.boronin.common.navigation.AppNavigator

/**
 * Created by Sergey Boronin on 27.01.2020.
 */
class MainNavigatorImpl : AppNavigator(), MainNavigator {
    override fun openDetails() {
        globalHandler?.open(DetailsFragment())
    }
}