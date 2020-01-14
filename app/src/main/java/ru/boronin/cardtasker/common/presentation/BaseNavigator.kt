package ru.boronin.cardtasker.common.presentation

import ru.boronin.core.api.navigator.Navigator
import ru.boronin.core.api.navigator.NavigatorHandler


open class BaseNavigator : Navigator {
  override var localHandler: NavigatorHandler? = null
  override var globalHandler: NavigatorHandler? = null
}