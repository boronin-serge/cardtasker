package ru.boronin.cardtasker.features.details.di

import androidx.fragment.app.FragmentActivity
import dagger.Module
import dagger.Provides
import ru.boronin.cardtasker.features.details.navigator.DetailsNavigator
import ru.boronin.cardtasker.features.details.navigator.DetailsNavigatorImpl
import ru.boronin.common.navigation.AppNavigatorHandlerImpl
import ru.boronin.core.api.navigator.NavigatorHandler

/**
 * Created by Sergey Boronin on 14.01.2020.
 */

@Module
class DetailsModule {

    @Provides
    fun provideNavigator(activity: FragmentActivity, containerId: Int): DetailsNavigator {
        return DetailsNavigatorImpl().apply {
            globalHandler = AppNavigatorHandlerImpl(
                activity.supportFragmentManager,
                containerId
            )
        }
    }
}