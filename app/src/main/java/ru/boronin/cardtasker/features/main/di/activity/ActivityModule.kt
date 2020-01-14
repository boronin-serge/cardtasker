package ru.boronin.cardtasker.features.main.di.activity

import androidx.fragment.app.FragmentActivity
import dagger.Module
import dagger.Provides
import ru.boronin.common.navigation.AppNavigatorHandlerImpl
import ru.boronin.core.api.navigator.NavigatorHandler

/**
 * Created by Sergey Boronin on 14.01.2020.
 */

@Module
class ActivityModule {

    @Provides
    fun provideNavigator(activity: FragmentActivity, containerId: Int): NavigatorHandler {
        return AppNavigatorHandlerImpl(activity.supportFragmentManager, containerId)
    }
}