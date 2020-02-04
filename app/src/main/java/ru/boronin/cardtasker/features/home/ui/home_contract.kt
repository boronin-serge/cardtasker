package ru.boronin.cardtasker.features.home.ui

import ru.boronin.cardtasker.common.presentation.mvp.MvpView

/**
 * Created by Sergey Boronin on 29.01.2020.
 */
interface HomeView : MvpView {
    fun openSmth()
}

interface HomeAction {
    fun openDetails()
}