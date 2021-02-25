package com.production.alarmsetup.presentation.timepicker

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.production.alarmsetup.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.takeWhile
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlin.math.abs

class TimePickerAdapter(
    private val items: List<String>,
    private val snappedPosition: StateFlow<Int>,
    private val orientation: Orientation
) :
    RecyclerView.Adapter<TimePickerAdapter.VH>() {

    private val scope = CoroutineScope(Dispatchers.Main)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH = VH(
        LayoutInflater.from(parent.context).inflate(R.layout.time_picker_view, parent, false),
    ).also {
        Timber.e("onCreateViewHolder with position")
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(position)
        Timber.e("onBindViewHolder with position $position")
    }

    override fun getItemCount() = Int.MAX_VALUE

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var currentPosition = -1
        val textView = itemView.findViewById<TextView>(R.id.text1)

        init {
            scope.launch {
                snappedPosition.collect {
                    Timber.e(it.toString() + "   " + currentPosition.toString() + "   " + textView.text)
                    when {
                        abs(it - currentPosition) == 0 -> textView.setTextColor(itemView.context.getColor(R.color.emperor_100))
                        abs(it - currentPosition) == 1 -> textView.setTextColor(itemView.context.getColor(R.color.emperor_50))
                        abs(it - currentPosition) == 2 -> textView.setTextColor(itemView.context.getColor(R.color.emperor_25))
                        else -> textView.setTextColor(itemView.context.getColor(R.color.emperor_0))
                    }
                }
            }
        }

        fun bind(position: Int) {
            currentPosition = position
            if (currentPosition >= 0) textView.text = items[position % items.size]
        }
    }
}

