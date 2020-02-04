package ru.boronin.cardtasker.features.home.navigator

import ru.boronin.cardtasker.common.presentation.DETAILS_REQUEST_KEY
import ru.boronin.cardtasker.features.details.ui.DetailsFragment
import ru.boronin.common.navigation.AppNavigator

/**
 * Created by Sergey Boronin on 14.01.2020.
 */
class HomeNavigatorImpl : AppNavigator(), HomeNavigator {
    override fun openDetails() {
        globalHandler?.openForResult(DetailsFragment(), DETAILS_REQUEST_KEY)
    }
}