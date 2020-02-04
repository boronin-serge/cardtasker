package ru.boronin.cardtasker.features.main.di.activity

import androidx.fragment.app.FragmentActivity
import dagger.Module
import dagger.Provides
import ru.boronin.cardtasker.features.details.navigator.DetailsNavigator
import ru.boronin.cardtasker.features.details.navigator.DetailsNavigatorImpl
import ru.boronin.cardtasker.features.details.ui.DetailsFragment
import ru.boronin.cardtasker.features.main.navigator.MainNavigator
import ru.boronin.cardtasker.features.main.navigator.MainNavigatorImpl
import ru.boronin.common.navigation.AppNavigatorHandlerImpl
import ru.boronin.core.api.navigator.NavigatorHandler
import javax.inject.Singleton

/**
 * Created by Sergey Boronin on 14.01.2020.
 */

@Module
class ActivityModule {

    @Provides
    fun provideNavigator(activity: FragmentActivity, containerId: Int): NavigatorHandler {
        return AppNavigatorHandlerImpl(activity.supportFragmentManager, containerId)
    }

    @Provides
    fun provideMainNavigator(
        navigatorHandler: NavigatorHandler
    ): MainNavigator {
        return MainNavigatorImpl().apply {
            globalHandler = navigatorHandler
        }
    }
}