package ru.boronin.cardtasker.features.details.ui

import android.view.View
import androidx.viewpager2.widget.CompositePageTransformer
import kotlinx.android.synthetic.main.details_fragment.*
import ru.boronin.cardtasker.R
import ru.boronin.cardtasker.common.presentation.mvp.BaseView
import ru.boronin.cardtasker.features.details.di.DetailsComponent
import ru.boronin.cardtasker.features.main.di.activity.ActivityComponent
import ru.boronin.common.view.viewpager2.transformer.OffsetPageTransformer
import ru.boronin.common.view.viewpager2.transformer.RotatePageTransformer
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
        (vpList?.adapter as DetailsAdapter).update(items)
    }

    // region private

    private fun initToolbar() {
        setVisibleToolbar(false)
    }

    private fun initList() {
        with(vpList) {
            adapter = DetailsAdapter()
            clipToPadding = false
            clipChildren = false
            offscreenPageLimit = 2

            val margin = -50
            val offset = 0

            setPageTransformer(CompositePageTransformer().also {
                it.addTransformer(OffsetPageTransformer(offset, margin))
                it.addTransformer(RotatePageTransformer())
            })
        }
    }

    private fun initListeners() {

    }

    // endregion
}
