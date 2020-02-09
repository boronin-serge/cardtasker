package ru.boronin.cardtasker.features.tasks.di

import dagger.BindsInstance
import dagger.Subcomponent
import ru.boronin.cardtasker.features.home.di.HomeComponent
import ru.boronin.cardtasker.features.home.di.HomeModule
import ru.boronin.cardtasker.features.tasks.ui.TasksFragment

@Subcomponent(modules = [TasksModule::class])
interface TasksComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance fragment: TasksFragment): TasksComponent
    }

    fun inject(fragment: TasksFragment)
}
        
        
        