package ru.boronin.cardtasker.features.home.di

import dagger.Module
import dagger.Provides
import ru.boronin.cardtasker.features.home.navigator.HomeNavigator
import ru.boronin.cardtasker.features.home.navigator.HomeNavigatorImpl
import ru.boronin.cardtasker.features.home.ui.HomeFragment
import ru.boronin.common.navigation.AppNavigatorHandlerImpl
import ru.boronin.core.api.navigator.NavigatorHandler

/**
 * Created by Sergey Boronin on 14.01.2020.
 */

@Module
class HomeModule {

    @Provides
    fun provideNavigator(
        navigatorHandler: NavigatorHandler,
        fragment: HomeFragment
    ): HomeNavigator {
        return HomeNavigatorImpl().apply {
            globalHandler = navigatorHandler
            localHandler = fragment.getLocalNavigator()
        }
    }
}