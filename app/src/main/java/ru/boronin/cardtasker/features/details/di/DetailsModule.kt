package ru.boronin.cardtasker.features.details.di

import dagger.Module
import dagger.Provides
import ru.boronin.cardtasker.features.details.navigator.DetailsNavigator
import ru.boronin.cardtasker.features.details.navigator.DetailsNavigatorImpl
import ru.boronin.cardtasker.features.details.ui.DetailsFragment
import ru.boronin.common.navigation.AppNavigatorHandlerImpl
import ru.boronin.core.api.navigator.NavigatorHandler

/**
 * Created by Sergey Boronin on 14.01.2020.
 */

@Module
class DetailsModule {

    @Provides
    fun provideNavigator(
        navigatorHandler: NavigatorHandler,
        fragment: DetailsFragment
    ): DetailsNavigator {
        return DetailsNavigatorImpl().apply {
            globalHandler = navigatorHandler
            localHandler = fragment.getLocalNavigator()
        }
    }
}