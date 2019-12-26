package ru.boronin.cardtasker.common.presentation

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import ru.boronin.core.api.navigator.BackListener

/**
 * Created by Sergey Boronin on 25.12.2019.
 */
abstract class BaseFragment : Fragment(),
    BackListener {

    // region BackListener

    override fun back() = false

    // endregion

}