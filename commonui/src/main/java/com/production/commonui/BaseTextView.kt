package com.production.commonui

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.textview.MaterialTextView

class BaseTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MaterialTextView(context, attrs, defStyleAttr) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        val measuredWidth = measuredWidth
        val tenPercentOfMeasuredWidth = measuredWidth * 0.1f
        val newWidth = measuredWidth + tenPercentOfMeasuredWidth.toInt()

        setMeasuredDimension(newWidth, measuredHeight)
    }
}