package ru.boronin.cardtasker.features.tasks.ui

import ru.boronin.cardtasker.common.presentation.mvp.BasePresenter
import ru.boronin.cardtasker.features.tasks.navigator.TasksNavigator
import javax.inject.Inject

class TasksPresenter @Inject constructor(
    private val navigator: TasksNavigator
) : BasePresenter<TasksView>(), TasksAction {
    
}