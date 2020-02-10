package ru.boronin.cardtasker.features.onboarding.ui

import ru.boronin.cardtasker.common.presentation.mvp.BasePresenter
import ru.boronin.cardtasker.features.onboarding.navigator.OnboardingNavigator
import javax.inject.Inject

class OnboardingPresenter @Inject constructor(
    private val navigator: OnboardingNavigator
) : BasePresenter<OnboardingView>(), OnboardingAction {

    override fun openHomeAction() {
        navigator.openHome()
    }
}