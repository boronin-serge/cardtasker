package ru.boronin.cardtasker.features.details.ui

import android.view.View
import ru.boronin.cardtasker.R
import ru.boronin.cardtasker.common.presentation.mvp.BaseView
import ru.boronin.cardtasker.features.details.di.DetailsComponent
import ru.boronin.cardtasker.features.main.di.activity.ActivityComponent
import javax.inject.Inject

/**
 * Created by Sergey Boronin on 14.01.2020.
 */
class DetailsFragment : BaseView<DetailsView, DetailsPresenter>(), DetailsView {

    @Inject
    override lateinit var presenter: DetailsPresenter

    private var component: DetailsComponent? = null

    override fun getLayout() = R.layout.details_fragment

    override fun onViewBound(view: View) {
        initToolbar()
    }

    override fun initDagger(activityComponent: ActivityComponent) {
        component = activityComponent.detailsFactory().create(this)
        component?.inject(this)
    }

    override fun clearDependencies() {
        component = null
    }

    override fun openSmth() {

    }

    // region private

    private fun initToolbar() {
        setVisibleToolbar(true)
        setVisibleToolbarBackButton(true)
    }

    // endregion
}
