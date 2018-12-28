package com.jascal.galatea.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.jascal.galatea.R
import com.jascal.galatea.ext.log


/**
 * @author ihave4cat
 * @describe a custom switcher used to change from two labels, can be dragged, can be clicked.
 * @data on 2018/12/27 10:00 PM
 * @email jascal@163.com
 * */

class ModelSwitcher @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : View(context, attrs, defStyleAttr) {

    companion object {
        private const val DIVIDER_LINE_WIDTH = 2
        private const val DISTANCE_BETWEEN_LABELS = 2
    }

    private var firstLabel: String = ""
    private var secondLabel: String = ""
    private var colorHint: Int = Color.BLACK
    private var colorSelected: Int = Color.BLUE
    private var textSize: Float = 30f

    private var textPaint: Paint
    private var boxPaint: Paint

    private var currentPosition: Int

    private var textWidth: Int
    private var textHeight: Int
    private var textBaseline: Float

    private var radius: Int
    private var between: Int

    init {
        val typeArray = context.obtainStyledAttributes(attrs, R.styleable.ModelSwitcher)
        firstLabel = typeArray.getString(R.styleable.ModelSwitcher_firstLabel)
        secondLabel = typeArray.getString(R.styleable.ModelSwitcher_secondLabel)
        colorHint = typeArray.getColor(R.styleable.ModelSwitcher_colorHint, colorHint)
        colorSelected = typeArray.getColor(R.styleable.ModelSwitcher_colorSelected, colorSelected)
        textSize = typeArray.getDimension(R.styleable.ModelSwitcher_textSize, textSize)
        typeArray.recycle()

        textPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        textPaint.textSize = textSize
        textPaint.color = colorHint

        val rect = Rect()
        textPaint.getTextBounds(firstLabel, 0, firstLabel.length, rect)
        textWidth = rect.width()
        textHeight = rect.height()

        val fontMetrics = textPaint.fontMetrics
        textBaseline = (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.bottom

        radius = textHeight
        between = DIVIDER_LINE_WIDTH

        currentPosition = 0

        boxPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        boxPaint.color = colorHint
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthSpecMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthSpecSize = MeasureSpec.getSize(widthMeasureSpec)

        val heightSpecMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightSpecSize = MeasureSpec.getSize(heightMeasureSpec)

        var w = widthSpecSize;
        var h = heightSpecSize;

        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            w = radius + textWidth + DISTANCE_BETWEEN_LABELS * radius + textWidth + radius
            h = textHeight * 2
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            w = radius + textWidth + DISTANCE_BETWEEN_LABELS * radius + textWidth + radius
            h = heightSpecSize
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            w = widthSpecSize
            h = textHeight * 2
        }
        setMeasuredDimension(w, h);
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // draw hint box
        boxPaint.color = colorHint
        canvas.drawRoundRect(0f, 0f, width.toFloat(), height.toFloat(), radius.toFloat(), radius.toFloat(), boxPaint)

        // draw selected box
        var boxX: Float
        boxPaint.color = colorSelected
        if (currentPosition == 0) {
            boxX = 0f + between
            log("current==1, target is ${boxX + dX}, left is ${0 + between}, right is ${width - textWidth - radius - radius - between}")
            boxX = when {
                boxX + dX < 0 + between -> 0f + between
                boxX + dX > width - textWidth - radius - radius - between -> (width - textWidth - radius - radius - between).toFloat()
                else -> boxX + dX
            }
            canvas.drawRoundRect(boxX, 0f + between, boxX + radius + textWidth + radius, (height - between).toFloat(), radius.toFloat(), radius.toFloat(), boxPaint)
        } else {
            boxX = (width - textWidth - radius - radius - between).toFloat()
            log("current==2, target is ${boxX + dX}, left is ${0 + between}, right is ${width - textWidth - radius - radius - between}")
            boxX = when {
                boxX + dX < 0 + between -> 0f + between
                boxX + dX > width - textWidth - radius - radius - between -> (width - textWidth - radius - radius - between).toFloat()
                else -> boxX + dX
            }
            canvas.drawRoundRect(boxX, 0f + between, boxX + radius + textWidth + radius, (height - between).toFloat(), radius.toFloat(), radius.toFloat(), boxPaint)
        }

        val textY = radius + textBaseline
        if (currentPosition == 0) {
            // draw first text
            textPaint.color = colorHint
            canvas.drawText(firstLabel, (radius + between).toFloat(), textY, textPaint)

            // draw second text
            textPaint.color = colorSelected
            canvas.drawText(secondLabel, (width - textWidth - radius - between).toFloat(), textY, textPaint)
        } else {
            // draw first text
            textPaint.color = colorSelected
            canvas.drawText(firstLabel, (radius + between).toFloat(), textY, textPaint)

            // draw second text
            textPaint.color = colorHint
            canvas.drawText(secondLabel, (width - textWidth - radius - between).toFloat(), textY, textPaint)
        }
    }

    private var laseX: Int = -1
    private var dX: Int = 0
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                log("down")
                laseX = event.x.toInt()
                dX = 0
                parent.requestDisallowInterceptTouchEvent(true)
            }
            MotionEvent.ACTION_MOVE -> {
                log("move")
                dX += (event.x - laseX).toInt()
                laseX = event.x.toInt()
                invalidate()
            }
            MotionEvent.ACTION_UP -> {
                log("up")
                currentPosition = if (event.x < width / 2) 0 else 1
                invalidate()
                parent.requestDisallowInterceptTouchEvent(false)
            }
            MotionEvent.ACTION_CANCEL -> {
                log("cancel")
                currentPosition = if (event.x < width / 2) 0 else 1
                invalidate()
                parent.requestDisallowInterceptTouchEvent(false)
            }
            else -> log("====! ${event.action}")
        }
        return true
    }
}