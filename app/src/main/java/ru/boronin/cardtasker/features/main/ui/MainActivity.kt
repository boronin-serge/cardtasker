package ru.boronin.cardtasker.features.main.ui

import android.annotation.SuppressLint
import android.os.Bundle
import ru.boronin.cardtasker.App
import ru.boronin.cardtasker.R
import ru.boronin.cardtasker.common.presentation.BaseActivity


class MainActivity : BaseActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).appComponent.activityComponent()
            .create(this, R.id.container)
            .inject(this)
    }
}
