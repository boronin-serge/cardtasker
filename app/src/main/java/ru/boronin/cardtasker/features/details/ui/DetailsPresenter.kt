package ru.boronin.cardtasker.features.details.ui

import ru.boronin.cardtasker.common.presentation.mvp.BasePresenter
import ru.boronin.cardtasker.features.details.navigator.DetailsNavigator
import javax.inject.Inject

/**
 * Created by Sergey Boronin on 14.01.2020.
 */

class DetailsPresenter @Inject constructor(
    private val navigator: DetailsNavigator
) : BasePresenter<DetailsView>(), DetailsAction {

    override fun backAction() {
        navigator.back()
    }
}