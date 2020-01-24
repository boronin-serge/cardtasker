package ru.boronin.cardtasker.features.main.ui

import ru.boronin.cardtasker.features.details.ui.DetailsFragment
import ru.boronin.core.api.navigator.NavigatorHandler
import javax.inject.Inject

/**
 * Created by Sergey Boronin on 24.01.2020.
 */
class MainPresenter @Inject constructor(
    private val navigator: NavigatorHandler
) {
    fun init() {
        navigator.open(DetailsFragment())
    }
}