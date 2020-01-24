package ru.boronin.cardtasker.common.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.boronin.cardtasker.R
import ru.boronin.cardtasker.features.main.di.activity.ActivityComponent
import ru.boronin.cardtasker.features.main.ui.MainActivity
import ru.boronin.common.navigation.ScreenResult
import ru.boronin.common.navigation.ScreenResultProvider
import ru.boronin.core.api.navigator.BackListener

/**
 * Created by Sergey Boronin on 25.12.2019.
 */
abstract class BaseFragment : Fragment(), BackListener, ScreenResultProvider {

    override fun onAttach(context: Context) {
        super.onAttach(context)

        initDagger((activity as MainActivity).activityComponent)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayout(), container, false)
    }

    abstract fun initDagger(activityComponent: ActivityComponent)

    abstract fun getLayout(): Int

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