package ru.boronin.cardtasker.common.presentation

import android.content.Intent
import androidx.fragment.app.Fragment
import ru.boronin.common.navigation.ScreenResult
import ru.boronin.common.navigation.ScreenResultProvider
import ru.boronin.core.api.navigator.BackListener

/**
 * Created by Sergey Boronin on 25.12.2019.
 */
abstract class BaseFragment : Fragment(), BackListener, ScreenResultProvider {


    // region ScreenResultProvider

    override var result: ScreenResult? = null

    override var resultHandler: Fragment? = null

    override fun setResult(resultCode: Int, data: Intent?) {
        // TODO: make
    }

    // endregion ScreenResultProvider


    // region BackListener

    override fun back() = false

    // endregion

}