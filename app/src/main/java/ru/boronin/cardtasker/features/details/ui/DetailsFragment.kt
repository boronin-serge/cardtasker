package ru.boronin.cardtasker.features.details.ui

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.details_fragment.*
import ru.boronin.cardtasker.R
import ru.boronin.cardtasker.common.presentation.BaseAdapter
import ru.boronin.cardtasker.common.presentation.mvp.BaseView
import ru.boronin.cardtasker.features.details.di.DetailsComponent
import ru.boronin.cardtasker.features.main.di.activity.ActivityComponent
import javax.inject.Inject

/**
 * Created by Sergey Boronin on 14.01.2020.
 */
class DetailsFragment : BaseView<DetailsView, DetailsPresenter, DetailsComponent>(), DetailsView {

    @Inject
    override lateinit var presenter: DetailsPresenter

    override fun getLayout() = R.layout.details_fragment

    override fun onViewBound(view: View) {
        initToolbar()
        initList()
        initListeners()
    }

    override fun initDagger(activityComponent: ActivityComponent) {
        component = activityComponent.detailsFactory().create(this)
        component?.inject(this)
    }

    override fun back() = false

    override fun openSmth() {

    }

    override fun updateList(items: List<String>) {
        (rvList?.adapter as DetailsAdapter).update(items)
    }

    // region private

    private fun initToolbar() {
        setVisibleToolbar(false)
    }

    private fun initList() {
        rvList?.layoutManager = LinearLayoutManager(activity)
        rvList?.adapter = DetailsAdapter()
    }

    private fun initListeners() {

    }

    // endregion
}
