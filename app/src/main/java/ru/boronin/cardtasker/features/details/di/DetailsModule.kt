package ru.boronin.cardtasker.features.details.di

import dagger.Module
import dagger.Provides
import ru.boronin.cardtasker.features.details.navigator.DetailsNavigator
import ru.boronin.cardtasker.features.details.navigator.DetailsNavigatorImpl
import ru.boronin.core.api.navigator.NavigatorHandler

/**
 * Created by Sergey Boronin on 14.01.2020.
 */

@Module
class DetailsModule {

    @Provides
    fun provideNavigator(navigatorHandler: NavigatorHandler): DetailsNavigator {
        return DetailsNavigatorImpl().apply {
            globalHandler = navigatorHandler
        }
    }
}