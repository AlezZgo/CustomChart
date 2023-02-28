package com.alezzgo.customchart

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class ChartView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var sum = 0
    private val paint = Paint().apply {
        color = Color.BLUE
        style = Paint.Style.STROKE
        isAntiAlias = true
        strokeWidth = 16f
    }

    private val metrics = Paint.FontMetrics()

    val centerX = 700f
    val centerY = 700f
    val radius = 600f

    var data = listOf<Int>()
        set(value) {
            field = value
            sum = value.sum()
            invalidate()
        }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawCircle(centerX, centerY, radius, paint)
        canvas.drawLine(centerX, centerY, centerX + radius, centerY, paint)
        canvas.drawLine(centerX, centerY, centerX , centerY + radius, paint)


    }


}