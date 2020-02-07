package ru.boronin.cardtasker.features.tasks.ui

import android.view.View
import kotlinx.android.synthetic.main.tasks_fragment.*
import ru.boronin.cardtasker.common.presentation.mvp.BaseView
import ru.boronin.cardtasker.features.tasks.di.TasksComponent
import ru.boronin.cardtasker.R
import ru.boronin.cardtasker.features.main.di.activity.ActivityComponent
import javax.inject.Inject

class TasksFragment : BaseView<TasksView, TasksPresenter>(), TasksView {
    
    @Inject 
    override lateinit var presenter: TasksPresenter

    private var component: TasksComponent? = null
    
    override fun getLayout() = R.layout.tasks_fragment
            
    override fun onViewBound(view: View) {
        initToolbar()
        initListeners()
    }

    override fun initDagger(activityComponent: ActivityComponent) {
        //component = activityComponent.tasksFactory().create(this)
        //component?.inject(this)
    }
    
    override fun clearDependencies() {
        component = null
    }

    // region private

    private fun initToolbar() {
        setVisibleToolbar(false)
    }

    private fun initListeners() {

    }

    // endregion

}