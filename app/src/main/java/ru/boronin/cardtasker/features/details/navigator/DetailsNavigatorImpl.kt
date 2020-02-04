package ru.boronin.cardtasker.features.details.navigator

import ru.boronin.common.navigation.AppNavigator

/**
 * Created by Sergey Boronin on 14.01.2020.
 */
class DetailsNavigatorImpl : AppNavigator(), DetailsNavigator {
    override fun openSmth() {
        //globalHandler?.open()
    }

    override fun back() {
        globalHandler?.back()
    }
}