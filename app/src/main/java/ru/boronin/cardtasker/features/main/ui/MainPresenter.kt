package ru.boronin.cardtasker.features.main.ui

import ru.boronin.cardtasker.features.main.navigator.MainNavigator
import javax.inject.Inject

/**
 * Created by Sergey Boronin on 24.01.2020.
 */
class MainPresenter @Inject constructor(
    private val navigator: MainNavigator
) {
    fun init() {
        navigator.openHome()
    }
}