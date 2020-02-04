package ru.boronin.cardtasker.features.home.ui

import ru.boronin.cardtasker.common.presentation.mvp.BasePresenter
import ru.boronin.cardtasker.features.home.navigator.HomeNavigator
import javax.inject.Inject

/**
 * Created by Sergey Boronin on 14.01.2020.
 */

class HomePresenter @Inject constructor(
    private val navigator: HomeNavigator
) : BasePresenter<HomeView>(), HomeAction {

    override fun openDetails() {
        navigator.openDetails()
    }
}