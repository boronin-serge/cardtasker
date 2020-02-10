package ru.boronin.cardtasker.features.onboarding.ui

import android.view.View
import kotlinx.android.synthetic.main.onboarding_fragment.*
import ru.boronin.cardtasker.common.presentation.mvp.BaseView
import ru.boronin.cardtasker.features.onboarding.di.OnboardingComponent
import ru.boronin.cardtasker.R
import ru.boronin.cardtasker.features.main.di.activity.ActivityComponent
import javax.inject.Inject

class OnboardingFragment : BaseView<OnboardingView, OnboardingPresenter, OnboardingComponent>(), OnboardingView {
    
    @Inject 
    override lateinit var presenter: OnboardingPresenter
    
    override fun getLayout() = R.layout.onboarding_fragment
            
    override fun onViewBound(view: View) {
        initToolbar()
        initListeners()
    }

    override fun initDagger(activityComponent: ActivityComponent) {
        component = activityComponent.onboardingFactory().create(this)
        component?.inject(this)
    }

    // region private

    private fun initToolbar() {
        setVisibleToolbar(false)
    }

    private fun initListeners() {

    }

    // endregion

}