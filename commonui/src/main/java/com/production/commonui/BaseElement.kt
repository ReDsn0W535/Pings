package com.production.commonui

import android.content.Context
import android.graphics.drawable.StateListDrawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import com.production.commonui.databinding.BaseElementBinding
import com.production.framework.ui.colorStateList
import com.production.framework.ui.drawable

class BaseElement @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {


    private val defaultAttrsSet = intArrayOf(
        R.attr.colorPrimary,
        android.R.attr.text,
        R.attr.icon,
    )
    private var binding = BaseElementBinding.inflate(LayoutInflater.from(context), this)

    init {
        this.setBackgroundResource(R.drawable.base_element_ripple)
        attrs?.let { attrs ->
            context.obtainStyledAttributes(attrs, defaultAttrsSet).apply {
                getString(defaultAttrsSet.indexOf(android.R.attr.text))?.let {
                    binding.mainText.text = it
                }
                getResourceId(defaultAttrsSet.indexOf(R.attr.icon), R.drawable.cross_icon_black).let {
                    binding.icon.setBackgroundResource(it)
                }
                recycle()
            }
            context.obtainStyledAttributes(attrs, R.styleable.BaseElement).apply {
                this.toString()
            }
        }
    }
}