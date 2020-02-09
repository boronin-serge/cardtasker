package ru.boronin.cardtasker.features.tasks.di

import dagger.Module
import dagger.Provides
import ru.boronin.cardtasker.features.tasks.navigator.TasksNavigator
import ru.boronin.cardtasker.features.tasks.navigator.TasksNavigatorImpl
import ru.boronin.cardtasker.features.tasks.ui.TasksFragment
import ru.boronin.common.navigation.AppNavigatorHandlerImpl
import ru.boronin.core.api.navigator.NavigatorHandler

@Module
class TasksModule {

    @Provides
    fun provideNavigator(
        navigatorHandler: NavigatorHandler,
        fragment: TasksFragment
    ): TasksNavigator {
        return TasksNavigatorImpl().apply {
            globalHandler = navigatorHandler
            localHandler = fragment.getLocalNavigator()
        }
    }
}