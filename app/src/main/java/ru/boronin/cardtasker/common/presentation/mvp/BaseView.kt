package ru.boronin.cardtasker.common.presentation.mvp

import android.os.Bundle
import android.view.View
import ru.boronin.cardtasker.common.presentation.BaseFragment

/**
 * Created by Sergey Boronin on 29.01.2020.
 */
abstract class BaseView<V : MvpView, P : MvpPresenter<V>> : MvpDelegateCallback<V, P>, BaseFragment(), MvpView {

    override val view: V
        get() = this as V

    abstract fun onViewBound(view: View)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attachView(this.view)

        onViewBound(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        presenter.detachView()
    }
}