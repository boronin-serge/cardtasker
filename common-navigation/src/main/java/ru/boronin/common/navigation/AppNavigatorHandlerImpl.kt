package ru.boronin.common.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import ru.boronin.core.api.navigator.NavigatorHandler
import kotlin.math.max

/**
 * Created by Sergey Boronin on 26.12.2019.
 */
class AppNavigatorHandlerImpl(
    private val fragmentManager: FragmentManager,
    private val containerId: Int
) : NavigatorHandler {

    override fun open(deepLink: String) {
        throw UnsupportedOperationException()
    }

    override fun open(obj: Any?, tag: String) {
        if (obj is Fragment) {
            pushFragment(obj, tag)
        }
    }

    override fun openForResult(obj: Any?, requestCode: Int, tag: String) {
        if (obj is ScreenResultProvider) {
            getLastFragment()?.apply {
                obj.result = ScreenResult(requestCode)
                obj.resultHandler = this
            }

            pushFragment(obj as Fragment, tag)
        }
    }

    override fun back() {
        fragmentManager.popBackStack()
    }

    override fun backWithDeliveryResult() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun backToTag(tag: String, deliveryResult: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun backToRoot(deliveryResult: Boolean) {

    }

    override fun pop(obj: Any?) {
        if (obj is Fragment) {
            fragmentManager.beginTransaction().remove(obj)
        }
    }

    override fun setRoot(obj: Any?) {
        if (obj is Fragment) {
            for(i in 0 .. getStackSize()) {
                fragmentManager.popBackStack()
            }
            pushFragment(obj)
        }
    }

    override fun replace(obj: Any) {
        if (obj is Fragment) {
            replaceFragment(obj)
        }
    }

    override fun getStackSize(): Int {
        return fragmentManager.backStackEntryCount
    }


    // region private

    private fun pushFragment(fragment: Fragment, tag: String = "") {
        fragmentManager.beginTransaction()
            .add(containerId, fragment, tag)
            .addToBackStack(null)
            .commit()
    }

    private fun replaceFragment(fragment: Fragment, tag: String = "") {
        fragmentManager.beginTransaction()
            .replace(containerId, fragment, tag)
            .addToBackStack(null)
            .commit()
    }

    private fun getLastFragment(): Fragment? {
        val index = max(getStackSize() - 1, 0)
        val tag =  fragmentManager.getBackStackEntryAt(index).name
        return fragmentManager.findFragmentByTag(tag)
    }

    // endregion
}