package ru.boronin.cardtasker.common.presentation.mvp

interface MvpDelegateCallback<V: MvpView, P : MvpPresenter<V>> {
  val presenter: P
  val view: V
}