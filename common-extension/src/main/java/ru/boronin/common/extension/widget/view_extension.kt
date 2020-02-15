package ru.boronin.common.extension.widget

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.KeyEvent
import android.view.View
import android.view.View.LAYER_TYPE_SOFTWARE
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.annotation.AnimRes
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.FontRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import ru.boronin.common.extension.core.hideKeyboard
import ru.boronin.common.utils.DEFAULT_INT

fun View.hideKeyboard() {
  context?.hideKeyboard(this)
}

fun View?.setMargin(
  start: Int = marginStart,
  top: Int = topMargin,
  end: Int = marginEnd,
  bottom: Int = bottomMargin
) {
  reapplyLayoutParams {
    with(it as? ViewGroup.MarginLayoutParams) {
      this?.marginStart = start
      this?.topMargin = top
      this?.marginEnd = end
      this?.bottomMargin = bottom
    }
  }
}

val View?.marginStart: Int
  get() = (this?.layoutParams as? ViewGroup.MarginLayoutParams)?.marginStart ?: DEFAULT_INT

val View?.topMargin: Int
  get() = (this?.layoutParams as? ViewGroup.MarginLayoutParams)?.topMargin ?: DEFAULT_INT

val View?.marginEnd: Int
  get() = (this?.layoutParams as? ViewGroup.MarginLayoutParams)?.marginEnd ?: DEFAULT_INT

val View?.bottomMargin: Int
  get() = (this?.layoutParams as? ViewGroup.MarginLayoutParams)?.bottomMargin ?: DEFAULT_INT

fun View?.reapplyLayoutParams(layoutParamsFun: (ViewGroup.LayoutParams) -> Unit) {
  this?.layoutParams
    ?.also { layoutParamsFun.invoke(it) }

  this?.requestLayout()
}

fun View.findViewTraversal(predicate: (View) -> Boolean): View? {
  if (predicate(this)) {
    return this
  }

  var result: View? = null
  if (this is ViewGroup) {
    traversalView {
      if (predicate(it)) {
        result = it
      }
    }
  }

  return result
}

fun ViewGroup.traversalView(action: (View) -> Unit) {
  for (i in 0 until childCount) {
    val child = getChildAt(i)
    action.invoke(child)

    if (child is ViewGroup) {
      child.traversalView(action)
    }
  }
}

fun TextView.addTextWatcher(
  beforeTextChangedFun: ((text: CharSequence?, start: Int, count: Int, after: Int) -> Unit)? = null,
  onTextChangedFun: ((text: CharSequence?, start: Int, before: Int, count: Int) -> Unit)? = null,
  afterTextChangedFun: ((text: Editable?) -> Unit)? = null
) = object : TextWatcher {
  override fun afterTextChanged(s: Editable?) {
    afterTextChangedFun?.invoke(s)
  }

  override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    beforeTextChangedFun?.invoke(s, start, count, after)
  }

  override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    onTextChangedFun?.invoke(s, start, before, count)
  }
}.apply { addTextChangedListener(this) }

fun View.focusChangeListener(focusFun: (Boolean) -> Unit) {
  setOnFocusChangeListener { _, hasFocus -> focusFun.invoke(hasFocus) }
}

fun View.enterKeyListener(keyFun: () -> Unit) {
  onKeyListener(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER, keyFun)
}

fun View.onKeyListener(keyEvent: Int, keyCode: Int, keyFun: () -> Unit) {
  setOnKeyListener { _, code, event ->
    if (keyEvent == event.action && code == keyCode) {
      keyFun.invoke()
      true
    } else {
      false
    }
  }
}

fun View.fadeOutIn(middleFun: () -> Unit) {
  val fadeOut = ObjectAnimator.ofFloat(this, "alpha", 1f, .0f)
  fadeOut.duration = 100L
  fadeOut.addListener(object : AnimatorListenerAdapter() {
    override fun onAnimationEnd(animation: Animator) {
      super.onAnimationEnd(animation)
      middleFun.invoke()
    }
  })

  val fadeIn = ObjectAnimator.ofFloat(this, "alpha", .0f, 1f)
  fadeIn.duration = 100L

  val mAnimationSet = AnimatorSet()
  mAnimationSet.play(fadeIn).after(fadeOut)
  mAnimationSet.start()
}

fun View.getDimensionPixelSize(@DimenRes res: Int) = context?.resources
  ?.getDimensionPixelSize(res) ?: DEFAULT_INT

fun View.getFont(@FontRes res: Int) = ResourcesCompat.getFont(context, res)
fun View.getColor(@ColorRes res: Int) = ContextCompat.getColor(context, res)
fun View.getColorStateList(@ColorRes res: Int) = ContextCompat.getColorStateList(context, res)

fun View.startAnimation(@AnimRes anim: Int) {
  val animation = AnimationUtils.loadAnimation(context, anim)
  startAnimation(animation)
}

fun View.generateBackgroundWithShadow(
  @ColorRes backgroundColor: Int,
  @DimenRes cornerRadius: Int,
  @ColorRes shadowColor: Int,
  @DimenRes elevation: Int,
  shadowGravity: Int
) {
  val cornerRadiusValue = getDimensionPixelSize(cornerRadius).toFloat()
  val elevationValue = getDimensionPixelSize(elevation)

  val shapeDrawablePadding = Rect()
  shapeDrawablePadding.left = elevationValue
  shapeDrawablePadding.right = elevationValue

  val dy: Float
  when (shadowGravity) {
    Gravity.TOP -> {
      shapeDrawablePadding.top = elevationValue * 2
      shapeDrawablePadding.bottom = elevationValue
      dy = -1 * elevationValue / 3f
    }
    Gravity.CENTER -> {
      shapeDrawablePadding.top = elevationValue
      shapeDrawablePadding.bottom = elevationValue
      dy = 0f
    }
    else -> {
      dy = 0f
    }
  }

  val outerRadius = floatArrayOf(
    cornerRadiusValue,
    cornerRadiusValue,
    cornerRadiusValue,
    cornerRadiusValue,
    cornerRadiusValue,
    cornerRadiusValue,
    cornerRadiusValue,
    cornerRadiusValue
  )

  val shapeDrawable = ShapeDrawable()
  shapeDrawable.setPadding(shapeDrawablePadding)
  shapeDrawable.paint.color = getColor(backgroundColor)
  shapeDrawable.paint.setShadowLayer(elevationValue.toFloat(), 0f, dy, getColor(shadowColor))
  shapeDrawable.shape = RoundRectShape(outerRadius, null, null)

  setLayerType(LAYER_TYPE_SOFTWARE, null)

  val drawable = LayerDrawable(arrayOf<Drawable>(shapeDrawable))
  drawable.setLayerInset(
    0,
      elevationValue, elevationValue * 2,
    elevationValue,elevationValue * 2
  ) // это paddings для сужения нашего View внутрь выделенного прямогульника.

  background = drawable
}