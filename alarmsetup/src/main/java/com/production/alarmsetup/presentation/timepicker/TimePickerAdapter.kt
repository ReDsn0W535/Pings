package com.production.alarmsetup.presentation.timepicker

import android.animation.ObjectAnimator
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.production.alarmsetup.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.math.abs

class TimePickerAdapter(
    private val items: List<String>,
    private val snappedPosition: StateFlow<Int>
) :
    RecyclerView.Adapter<TimePickerAdapter.VH>() {

    private val scope = CoroutineScope(Dispatchers.Default)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH = VH(
        LayoutInflater.from(parent.context).inflate(R.layout.time_picker_view, parent, false),
    )

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount() = Int.MAX_VALUE


    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int) {
            val textView = itemView.findViewById<TextView>(R.id.text1)
            textView.text = items[position % items.size]
            scope.launch {
                snappedPosition.collect {
                    when {
                        abs(it - position) == 0 -> textView.setTextColor(itemView.context.getColor(R.color.emperor_100))
                        abs(it - position) == 1 -> textView.setTextColor(itemView.context.getColor(R.color.emperor_50))
                        abs(it - position) == 2 -> textView.setTextColor(itemView.context.getColor(R.color.emperor_25))
                        else -> textView.setTextColor(itemView.context.getColor(R.color.emperor_0))
                    }
                }
            }
        }
    }
}