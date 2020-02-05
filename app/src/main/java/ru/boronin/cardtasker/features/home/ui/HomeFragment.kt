package ru.boronin.cardtasker.features.home.ui

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.home_fragment.*
import ru.boronin.cardtasker.R
import ru.boronin.cardtasker.common.presentation.DATA_KEY
import ru.boronin.cardtasker.common.presentation.mvp.BaseView
import ru.boronin.cardtasker.features.home.di.HomeComponent
import ru.boronin.cardtasker.features.main.di.activity.ActivityComponent
import ru.boronin.cardtasker.features.main.ui.MainActivity
import ru.boronin.common.utils.DEFAULT_STRING
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

        button?.setOnClickListener {
            presenter.openDetails()
        }

        initToolbar()
        initBottomBar()
        initListeners()
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            val info = data?.getStringExtra(DATA_KEY)
            text?.text = info ?: DEFAULT_STRING
        }
    }

    override fun back() = false

    // region private

    private fun initToolbar() {
        setVisibleToolbar(false)
    }

    private fun initListeners() {

    }

    private fun initBottomBar() {
        val bottomView = (requireActivity() as MainActivity).bottomNavigation
        bottomView?.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.menuItem1 -> {
                    root?.setBackgroundColor(Color.WHITE)
                    true
                }
                R.id.menuItem2 -> {
                    root?.setBackgroundColor(Color.RED)
                    true
                }
                R.id.menuItem3 -> {
                    root?.setBackgroundColor(Color.YELLOW)
                    true
                }
                else -> false
            }
        }
    }

    // endregion
}
