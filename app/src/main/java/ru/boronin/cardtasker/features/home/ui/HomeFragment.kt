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
import ru.boronin.common.extension.core.findColor
import ru.boronin.common.extension.widget.fadeOutIn
import ru.boronin.common.utils.DEFAULT_COLOR
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

    // region private

    private fun initToolbar() {
        setVisibleToolbar(false)
    }

    private fun initListeners() {

    }

    private fun initBottomBar() {
//        bottomNavigation?.setOnNavigationItemSelectedListener { item ->
//            switchTab(item.itemId)
//            true
//        }
        customTabLayout.addTabs(
            listOf(
                TabData(
                    R.drawable.ic_playlist_add_check_black_24dp,
                    getString(R.string.bottomBar_item1)
                ),
                TabData(
                    R.drawable.ic_alarm_black_24dp,
                    getString(R.string.bottomBar_item2)
                ),
                TabData(
                    R.drawable.ic_notifications_none_black_24dp,
                    getString(R.string.bottomBar_item3)
                ),
                TabData(
                    R.drawable.ic_settings_black_24dp,
                    getString(R.string.bottomBar_item4)
                )
            )
        )
        customTabLayout.setActiveIconColor(context.findColor(R.color.colorAccent) ?: DEFAULT_COLOR)
        customTabLayout.setActiveTextColor(context.findColor(R.color.colorAccent) ?: DEFAULT_COLOR)
        customTabLayout.activateTab(0)
        customTabLayout.setOnTabClickListener {index ->
            if (index != viewPager2.currentItem) {
                viewPager2.fadeOutIn { viewPager2.setCurrentItem(index, false) }
            }
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
