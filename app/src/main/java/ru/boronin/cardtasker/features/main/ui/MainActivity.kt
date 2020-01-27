package ru.boronin.cardtasker.features.main.ui

import android.os.Bundle
import ru.boronin.cardtasker.R
import ru.boronin.cardtasker.common.presentation.BaseActivity
import ru.boronin.cardtasker.features.main.di.activity.ActivityComponent
import ru.boronin.cardtasker.features.main.di.app.AppComponent
import javax.inject.Inject


class MainActivity : BaseActivity() {

    @Inject
    lateinit var presenter: MainPresenter

    var activityComponent: ActivityComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.init()
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
}
