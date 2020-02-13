package ru.boronin.cardtasker.common.presentation.views

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.TypedValue
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Sergey Boronin on 13.02.2020.
 */
class CustomRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {
    private val CORNER_RADIUS = 20.0f

    private var maskBitmap: Bitmap? = null
    private var paint: Paint? = null
    private var maskPaint:Paint? = null
    private var cornerRadius = 0f

    init {
        init(context, attrs, defStyleAttr)
    }

    private fun init(
        context: Context,
        attrs: AttributeSet,
        defStyle: Int
    ) {
        val metrics = context.resources.displayMetrics
        cornerRadius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, CORNER_RADIUS, metrics)
        paint = Paint(Paint.ANTI_ALIAS_FLAG)
        maskPaint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.FILTER_BITMAP_FLAG)
        maskPaint!!.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
        setWillNotDraw(false)
    }

    override fun draw(canvas: Canvas) {
        val offscreenBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val offscreenCanvas = Canvas(offscreenBitmap)
        super.draw(offscreenCanvas)
        if (maskBitmap == null) {
            maskBitmap = createMask(width, height)
        }
        offscreenCanvas.drawBitmap(maskBitmap!!, 0f, 0f, maskPaint)
        canvas.drawBitmap(offscreenBitmap, 0f, 0f, paint)
    }

    private fun createMask(width: Int, height: Int): Bitmap {
        val mask = Bitmap.createBitmap(width, height, Bitmap.Config.ALPHA_8)
        val canvas = Canvas(mask)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = Color.WHITE
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)

        val corners = floatArrayOf(
            cornerRadius, cornerRadius, // Top left radius in px
            cornerRadius, cornerRadius, // Top right radius in px
            0f, 0f,                     // Bottom right radius in px
            0f, 0f                      // Bottom left radius in px
        )

        val path = Path()
        path.addRoundRect(RectF(0f, 0f, width.toFloat(), height.toFloat()), corners, Path.Direction.CW)

        canvas.drawPath(path, paint)
        return mask
    }

}