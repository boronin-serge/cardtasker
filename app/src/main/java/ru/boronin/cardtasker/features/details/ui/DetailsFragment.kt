package ru.boronin.cardtasker.features.details.ui

import android.content.Context
import ru.boronin.cardtasker.R
import ru.boronin.cardtasker.common.presentation.BaseFragment
import ru.boronin.cardtasker.features.details.di.DaggerDetailsComponent
import javax.inject.Inject

/**
 * Created by Sergey Boronin on 14.01.2020.
 */
class DetailsFragment : BaseFragment() {

    @Inject
    lateinit var presenter: DetailsPresenter

    override fun onAttach(context: Context) {
        super.onAttach(context)

        DaggerDetailsComponent.factory()
            .create(requireActivity(), R.id.container)
            .inject(this)
    }
}