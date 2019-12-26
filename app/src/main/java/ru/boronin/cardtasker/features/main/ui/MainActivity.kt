package ru.boronin.cardtasker.features.main.ui

import android.os.Bundle
import ru.boronin.cardtasker.R
import ru.boronin.cardtasker.common.presentation.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
