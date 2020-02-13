package ru.boronin.cardtasker.features.details.ui

import ru.boronin.cardtasker.common.presentation.mvp.MvpView

/**
 * Created by Sergey Boronin on 29.01.2020.
 */
interface DetailsView : MvpView {
    fun openSmth()
    fun updateList(items: List<String>)
}

interface DetailsAction {
    fun backAction()
}