package ru.boronin.cardtasker.features.onboarding.ui

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.onboarding_page.view.*
import ru.boronin.cardtasker.R
import ru.boronin.cardtasker.common.presentation.BaseAdapter
import ru.boronin.cardtasker.features.onboarding.model.OnboardingModel

class OnboardingAdapter : BaseAdapter<OnboardingAdapter.PagerVH, OnboardingModel>() {

    override fun getItemLayout() = R.layout.onboarding_page

    override fun initViewHolder(itemView: View) = PagerVH(itemView)

    override fun onBindViewHolder(holder: PagerVH, position: Int) {
        holder.bind(items[position])
    }

    class PagerVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val image = itemView.ivLogo
        private val desc = itemView.tvDesc

        fun bind(model: OnboardingModel) {
            image.setImageResource(model.imgRes)
            desc.text = itemView.context.getString(model.descRes)
            itemView.setBackgroundColor(model.color)
        }
    }
}
