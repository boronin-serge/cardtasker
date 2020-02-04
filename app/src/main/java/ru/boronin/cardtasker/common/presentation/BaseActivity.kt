package ru.boronin.cardtasker.common.presentation

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import ru.boronin.cardtasker.App
import ru.boronin.cardtasker.features.main.di.app.AppComponent
import ru.boronin.common.navigation.BackPressDelegate
import ru.boronin.common.navigation.BackPressDelegateImpl

/**
 * Created by Sergey Boronin on 25.12.2019.
 */
abstract class BaseActivity : AppCompatActivity(), BackPressDelegate by BackPressDelegateImpl() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDagger((application as App).appComponent)
    }

    override fun onDestroy() {
        super.onDestroy()

        clearDependencies()
    }

    override fun onBackPressed() {
        backPressed { super.onBackPressed() }
    }

    abstract fun initDagger(appComponent: AppComponent)
    abstract fun clearDependencies()
}