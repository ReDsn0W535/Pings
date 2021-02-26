package com.production.commonui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import coil.load
import com.production.commonui.databinding.BaseElementBinding
import com.production.framework.ui.dpToPx
import com.production.framework.ui.drawable

class BaseElement @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private enum class Size {
        BIG, SMALL
    }

    private val defaultAttrsSet = intArrayOf(
        R.attr.colorPrimary,
        android.R.attr.text,
        R.attr.icon,
    )
    private var binding = BaseElementBinding.inflate(LayoutInflater.from(context), this)

    var additionalText: String = ""
        set(value) {
            if (field == value)
                return
            if (value.isNotEmpty())
                binding.additionalText.text = value
            else binding.additionalText.isVisible = false
            field = value
        }

    init {
        this.apply {
            setBackgroundResource(R.drawable.base_element_ripple)
            clipChildren = false
            clipToPadding = true
        }
        attrs?.let { attrs ->
            context.obtainStyledAttributes(attrs, defaultAttrsSet).apply {
                getString(defaultAttrsSet.indexOf(android.R.attr.text))?.let {
                    binding.mainText.text = it
                }
                getResourceId(defaultAttrsSet.indexOf(R.attr.icon), R.drawable.cross_icon_black).let {
                    context.drawable(it)?.let { image ->
                        val layoutParams: ViewGroup.LayoutParams = binding.icon.layoutParams
                        layoutParams.width = image.minimumWidth
                        layoutParams.height = image.minimumHeight
                        binding.icon.layoutParams = layoutParams
                        binding.icon.load(image)
                    }
                }
                recycle()
            }
            context.obtainStyledAttributes(attrs, R.styleable.BaseElement).apply {
                additionalText = getString(R.styleable.BaseElement_additionalText) ?: ""

                val marginSize = when (Size.values()[
                    getInt(
                        R.styleable.BaseElement_size,
                        Size.SMALL.ordinal
                    )
                ]) {
                    Size.BIG -> context.dpToPx(29)
                    Size.SMALL -> context.dpToPx(18)
                }
                (binding.mainText.layoutParams as LayoutParams).apply {
                    topMargin = marginSize
                    bottomMargin = marginSize
                }
            }
        }
    }
}