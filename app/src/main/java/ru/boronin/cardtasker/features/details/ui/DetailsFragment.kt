package ru.boronin.cardtasker.features.details.ui

import android.app.Activity
import android.view.View
import androidx.core.os.bundleOf
import kotlinx.android.synthetic.main.details_fragment.*
import ru.boronin.cardtasker.R
import ru.boronin.cardtasker.common.presentation.DATA_KEY
import ru.boronin.cardtasker.common.presentation.mvp.BaseView
import ru.boronin.cardtasker.features.details.di.DetailsComponent
import ru.boronin.cardtasker.features.main.di.activity.ActivityComponent
import ru.boronin.common.extension.core.intentOf
import javax.inject.Inject

/**
 * Created by Sergey Boronin on 14.01.2020.
 */
class DetailsFragment : BaseView<DetailsView, DetailsPresenter>(), DetailsView,
    View.OnClickListener {

    @Inject
    override lateinit var presenter: DetailsPresenter

    private var component: DetailsComponent? = null

    override fun getLayout() = R.layout.details_fragment

    override fun onViewBound(view: View) {
        initToolbar()
        initListeners()
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

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.button -> {
                setResult(Activity.RESULT_OK, intentOf(DATA_KEY to "info"))
                presenter.backAction()
            }
        }
    }

    // region private

    private fun initToolbar() {
        setVisibleToolbar(false)
    }

    private fun initListeners() {
        button?.setOnClickListener(this)
    }

    // endregion
}
