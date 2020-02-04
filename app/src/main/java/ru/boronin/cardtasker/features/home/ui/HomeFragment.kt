package ru.boronin.cardtasker.features.home.ui

import android.view.View
import ru.boronin.cardtasker.R
import ru.boronin.cardtasker.common.presentation.mvp.BaseView
import ru.boronin.cardtasker.features.home.di.HomeComponent
import ru.boronin.cardtasker.features.main.di.activity.ActivityComponent
import javax.inject.Inject

/**
 * Created by Sergey Boronin on 14.01.2020.
 */
class HomeFragment : BaseView<HomeView, HomePresenter>(), HomeView {

    @Inject
    override lateinit var presenter: HomePresenter

    private var component: HomeComponent? = null

    override fun getLayout() = R.layout.home_fragment

    override fun onViewBound(view: View) {

        view.setOnClickListener {
            presenter.openDetails()
        }

        initToolbar()
    }

    override fun initDagger(activityComponent: ActivityComponent) {
        component = activityComponent.homeFactory().create(this)
        component?.inject(this)
    }

    override fun clearDependencies() {
        component = null
    }

    override fun openSmth() {

    }

    override fun back() = false

    // region private

    private fun initToolbar() {
        setVisibleToolbar(true)
        setVisibleToolbarBackButton(true)
    }

    // endregion
}
