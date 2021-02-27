package com.production.commonui.baseElement

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import coil.load
import com.production.commonui.R
import com.production.framework.ui.drawable

class ImageElement @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BaseElement<ImageView>(context, attrs, defStyleAttr) {
    override val payloadView = ImageView(context)

    init {
        context.obtainStyledAttributes(attrs, R.styleable.ImageElement).apply {
            getResourceId(R.styleable.ImageElement_iconSource, R.drawable.cross_icon_black).let {
                context.drawable(it)?.let { image ->
                    endElementLayoutParams.width = image.minimumWidth
                    endElementLayoutParams.height = image.minimumHeight
                    binding.icon.layoutParams = endElementLayoutParams
                    binding.icon.load(image)
                }
            }
            recycle()
        }
    }
}