package ru.boronin.cardtasker.features.main.ui

import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import ru.boronin.cardtasker.R
import ru.boronin.cardtasker.common.presentation.BaseActivity
import ru.boronin.cardtasker.features.main.di.activity.ActivityComponent
import ru.boronin.cardtasker.features.main.di.app.AppComponent
import ru.boronin.common.navigation.AppNavigatorHandlerImpl
import ru.boronin.common.utils.DEFAULT_BOOLEAN
import ru.boronin.core.api.navigator.BackListener
import ru.boronin.core.api.navigator.NavigatorHandler
import javax.inject.Inject


class MainActivity : BaseActivity() {

    @Inject
    lateinit var presenter: MainPresenter

    @Inject
    lateinit var navigator: NavigatorHandler

    var activityComponent: ActivityComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        attachNavigator(navigator as AppNavigatorHandlerImpl)

        presenter.init()
        initListeners()
    }

    override fun initDagger(appComponent: AppComponent) {
        activityComponent = appComponent
            .activityFactory()
            .create(this, R.id.container)

        activityComponent?.inject(this)
    }

    override fun clearDependencies() {
        activityComponent = null
    }


    // region private

    private fun initListeners() {
        bottomNavigation?.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.menuItem1 -> {
                    true
                }
                R.id.menuItem2 -> {
                    true
                }
                R.id.menuItem3 -> {
                    true
                }
                else -> false
            }
        }
    }

    // endregion
}
