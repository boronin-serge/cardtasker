package ru.boronin.cardtasker.features.home.ui

import android.view.View
import kotlinx.android.synthetic.main.home_fragment.*
import ru.boronin.cardtasker.R
import ru.boronin.cardtasker.common.presentation.ViewPagerFragmentAdapter
import ru.boronin.cardtasker.common.presentation.mvp.BaseView
import ru.boronin.cardtasker.features.details.ui.DetailsFragment
import ru.boronin.cardtasker.features.home.di.HomeComponent
import ru.boronin.cardtasker.features.main.di.activity.ActivityComponent
import ru.boronin.cardtasker.features.tasks.ui.TasksFragment
import ru.boronin.common.extension.widget.fadeOutIn
import javax.inject.Inject

/**
 * Created by Sergey Boronin on 14.01.2020.
 */
class HomeFragment : BaseView<HomeView, HomePresenter, HomeComponent>(), HomeView {

    @Inject
    override lateinit var presenter: HomePresenter

    private val bottomItems = listOf(R.id.menuItem1, R.id.menuItem2, R.id.menuItem3, R.id.menuItem4)

    override fun getLayout() = R.layout.home_fragment

    override fun onViewBound(view: View) {
        initToolbar()
        initViewPager()
        initBottomBar()
        initListeners()
    }

    override fun initDagger(activityComponent: ActivityComponent) {
        component = activityComponent.homeFactory().create(this)
        component?.inject(this)
    }

    override fun openSmth() {

    }

    override fun back() = false

    // region private

    private fun initToolbar() {
        setVisibleToolbar(false)
    }

    private fun initListeners() {

    }

    private fun initBottomBar() {
        bottomNavigation?.setOnNavigationItemSelectedListener { item ->
            switchTab(item.itemId)
            true
        }
    }

    private fun switchTab(menuId: Int) {
        val index = bottomItems.indexOf(menuId)
        if (index != viewPager2.currentItem) {
            viewPager2.fadeOutIn { viewPager2.setCurrentItem(index, false) }
        }
    }

    private fun initViewPager() {
        val adapter = ViewPagerFragmentAdapter(requireActivity())
        viewPager2?.apply {
            this.adapter = adapter
            isUserInputEnabled = false
        }
        adapter.update(
            listOf(
                TasksFragment(),
                DetailsFragment(),
                TasksFragment(),
                DetailsFragment()
            )
        )
    }

    // endregion
}
