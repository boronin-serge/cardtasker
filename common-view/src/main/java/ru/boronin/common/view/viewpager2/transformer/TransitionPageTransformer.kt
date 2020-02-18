package ru.boronin.common.view.viewpager2.transformer

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs
import kotlin.math.max


/**
 * Created by Sergey Boronin on 04.12.2019.
 */
class TransitionPageTransformer : ViewPager2.PageTransformer {

  private val MIN_SCALE = 0.85f
  private val MIN_ALPHA = 0.9f

  override fun transformPage(page: View, position: Float) {
    val pageWidth = page.width
    val pageHeight = page.height

    when {
        position < -1 -> {
          //page.alpha = 0f
          page.scaleX = MIN_SCALE
        }
        position <= 1 -> {
          val scaleFactor = max(MIN_SCALE, 1 - abs(position / 5))
          val vertMargin = pageHeight * (1 - scaleFactor) / 2
          val horzMargin = pageWidth * (1 - scaleFactor) / 2
          if (position < 0) {
            page.translationX = horzMargin - vertMargin / 2
          } else {
            page.translationX = -horzMargin + vertMargin / 2
          }

          page.scaleX = scaleFactor
          page.scaleY = scaleFactor

          page.alpha = MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA)
        }
        else -> {
          //page.alpha = 0f
          page.scaleX = MIN_SCALE
        }
    }
  }
}