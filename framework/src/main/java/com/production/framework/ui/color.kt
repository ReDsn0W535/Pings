package com.production.framework.ui

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.graphics.drawable.RippleDrawable
import android.util.TypedValue
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.FontRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import kotlin.math.roundToInt

@ColorInt
fun Context.color(@ColorRes colorResId: Int) =
    ContextCompat.getColor(this, colorResId)

fun Context.colorStateList(colorStateListResId: Int): ColorStateList? =
    AppCompatResources.getColorStateList(this, colorStateListResId)

fun Context.drawable(@DrawableRes drawableRes: Int): Drawable? =
    AppCompatResources.getDrawable(this, drawableRes)

fun Context.font(@FontRes fontResId: Int) =
    ResourcesCompat.getFont(this, fontResId)

fun Context.sp(value: Number): Int {
    val fValue = value.toFloat()
    return when {
        fValue <= 0 -> 0
        else -> TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, fValue, resources.displayMetrics).roundToInt()
    }
}

fun Context.dpToPx(value: Number): Int {
    val fValue = value.toFloat()
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, fValue, resources.displayMetrics).roundToInt()
}

fun Context.dimen(@DimenRes dimenId: Int): Float = resources.getDimension(dimenId)

fun Context.pxToDp(value: Number): Int {
    val fValue = value.toFloat()
    return when {
        fValue <= 0 -> 0
        else -> (fValue / resources.displayMetrics.density).toInt()
    }
}

fun Context.pxToSp(value: Number): Int {
    val fValue = value.toFloat()
    return when {
        fValue <= 0 -> 0
        else -> (fValue / resources.displayMetrics.scaledDensity).toInt()
    }
}
