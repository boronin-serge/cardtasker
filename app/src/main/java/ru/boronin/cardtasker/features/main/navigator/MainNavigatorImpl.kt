package ru.boronin.cardtasker.features.main.navigator

import ru.boronin.cardtasker.common.presentation.BaseNavigator
import ru.boronin.cardtasker.features.details.ui.DetailsFragment

/**
 * Created by Sergey Boronin on 27.01.2020.
 */
class MainNavigatorImpl : BaseNavigator(), MainNavigator {
    override fun openDetails() {
        globalHandler?.open(DetailsFragment())
    }
}