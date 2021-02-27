package com.production.commonui.baseElement

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.production.commonui.R
import com.production.commonui.databinding.BaseElementBinding
import com.production.framework.ui.dpToPx
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.distinctUntilChanged

abstract class BaseElement<T : View> @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    abstract val payloadView: T

    protected val binding = BaseElementBinding.inflate(LayoutInflater.from(context), this)

    protected val endElementLayoutParams: ViewGroup.LayoutParams = binding.icon.layoutParams

    protected val _state = MutableSharedFlow<Boolean>(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    ).also {
        it.tryEmit(false)
    }

    protected val defaultAttrsSet = intArrayOf(
        R.attr.colorPrimary,
        R.attr.boxColor,
        android.R.attr.text,
        R.attr.icon,
    )
    var additionalText: String = ""
        set(value) {
            if (field == value)
                return
            if (value.isNotEmpty())
                binding.additionalText.text = value
            else binding.additionalText.isVisible = false
            field = value
        }

    val state = _state.distinctUntilChanged()

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

    private enum class Size {
        BIG, SMALL
    }
}