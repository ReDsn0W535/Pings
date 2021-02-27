package com.production.commonui.baseElement

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.util.AttributeSet
import androidx.core.view.isVisible
import com.production.commonui.R
import com.google.android.material.checkbox.MaterialCheckBox

class CheckboxElement @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseElement<MaterialCheckBox>(context, attrs, defStyleAttr) {
    override val payloadView = MaterialCheckBox(context)

    init {
        val states = arrayOf(
            intArrayOf(android.R.attr.state_active),
            intArrayOf(-android.R.attr.state_active),
            intArrayOf(android.R.attr.state_enabled),
            intArrayOf(-android.R.attr.state_enabled),
            intArrayOf(android.R.attr.state_active),
            intArrayOf(-android.R.attr.state_active),
            intArrayOf(android.R.attr.state_checked),
            intArrayOf(-android.R.attr.state_checked)
        )
        val checkboxColor: Int
        context.obtainStyledAttributes(attrs, defaultAttrsSet).apply {
            checkboxColor = getColor(
                defaultAttrsSet.indexOf(R.attr.boxColor), resources.getColor(R.color.black_100, null)
            )
            recycle()
        }
        val colors = intArrayOf(
            checkboxColor,
            checkboxColor,
            checkboxColor,
            checkboxColor,
            checkboxColor,
            checkboxColor,
            checkboxColor,
            checkboxColor
        )
        payloadView.backgroundTintList = ColorStateList(states, colors)
        binding.icon.isVisible = false
        binding.additionalText.isVisible = false
        payloadView.isUseMaterialThemeColors = false
        addView(payloadView, endElementLayoutParams)
        payloadView.setOnCheckedChangeListener { _, isChecked ->
            _state.tryEmit(isChecked)
        }
        this.setOnClickListener {
            payloadView.isChecked = !payloadView.isChecked
        }
         payloadView.isChecked = true
         payloadView.isChecked = false
    }
}
