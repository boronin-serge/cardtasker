package ru.boronin.cardtasker.features.details.ui

import android.view.Gravity
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.details_fragment.*
import kotlinx.android.synthetic.main.onboarding_page.view.*
import ru.boronin.cardtasker.R
import ru.boronin.cardtasker.common.presentation.BaseAdapter
import ru.boronin.common.extension.widget.generateBackgroundWithShadow

/**
 * Created by Sergey Boronin on 13.02.2020.
 */
class DetailsAdapter : BaseAdapter<DetailsAdapter.PagerVH, String>() {

    override fun getItemLayout() = R.layout.details_list_item

    override fun initViewHolder(itemView: View) = PagerVH(itemView)

    override fun onBindViewHolder(holder: PagerVH, position: Int) {
        holder.bind(items[position])
    }

    class PagerVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val desc = itemView.tvDesc

        init {
//            itemView.generateBackgroundWithShadow(
//                android.R.color.white,
//                R.dimen.cornerRadius,
//                android.R.color.darker_gray,
//                R.dimen.elevation,
//                Gravity.CENTER
//            )
        }

        fun bind(model: String) {
            desc.text = model
        }
    }
}