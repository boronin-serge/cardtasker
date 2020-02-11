package ru.boronin.cardtasker.features.onboarding.ui

import android.graphics.Color
import android.view.View
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.onboarding_fragment.*
import kotlinx.android.synthetic.main.onboarding_fragment.viewPager2
import ru.boronin.cardtasker.common.presentation.mvp.BaseView
import ru.boronin.cardtasker.features.onboarding.di.OnboardingComponent
import ru.boronin.cardtasker.R
import ru.boronin.cardtasker.common.presentation.ViewPagerFragmentAdapter
import ru.boronin.cardtasker.features.details.ui.DetailsFragment
import ru.boronin.cardtasker.features.main.di.activity.ActivityComponent
import ru.boronin.cardtasker.features.onboarding.model.OnboardingModel
import ru.boronin.cardtasker.features.tasks.ui.TasksFragment
import ru.boronin.common.utils.DEFAULT_INT
import javax.inject.Inject

class OnboardingFragment : BaseView<OnboardingView, OnboardingPresenter, OnboardingComponent>(), OnboardingView,
    View.OnClickListener {
    
    @Inject 
    override lateinit var presenter: OnboardingPresenter

    private val pages = listOf(
        OnboardingModel(R.drawable.ic_spellcheck_black_24dp, R.string.onboarding_firstPage, Color.YELLOW),
        OnboardingModel(R.drawable.ic_tag_faces_black_24dp, R.string.onboarding_secondPage, Color.RED)
    )
    
    override fun getLayout() = R.layout.onboarding_fragment
            
    override fun onViewBound(view: View) {
        initToolbar()
        initViewPager()
        initListeners()
    }

    override fun initDagger(activityComponent: ActivityComponent) {
        component = activityComponent.onboardingFactory().create(this)
        component?.inject(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btnNext -> {
                val currentIndex = viewPager2?.currentItem ?: DEFAULT_INT
                if (currentIndex < pages.size - 1) {
                    viewPager2?.currentItem = currentIndex + 1
                } else {
                    presenter.openHomeAction()
                }
            }
        }
    }

    // region private

    private fun initToolbar() {
        setVisibleToolbar(false)
    }

    private fun initListeners() {
        btnNext?.setOnClickListener(this)
    }

    private fun initViewPager() {
        val adapter = OnboardingAdapter()
        viewPager2?.apply {
            this.adapter = adapter
            isUserInputEnabled = false
        }
        adapter.update(pages)
    }

    // endregion

}