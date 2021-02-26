package com.production.alarmsetup.presentation.timepicker

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.core.view.get
import androidx.core.view.size
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_IDLE
import androidx.recyclerview.widget.SnapHelper
import com.production.alarmsetup.R
import com.production.framework.recyclerview.getSnapPosition
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class TimePickerScrollListener(
    private val snapHelper: SnapHelper,
) : RecyclerView.OnScrollListener() {
    val snapFlow = MutableStateFlow(RecyclerView.NO_POSITION)

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        maybeNotifySnapPositionChange(recyclerView)
    }

    private fun maybeNotifySnapPositionChange(recyclerView: RecyclerView) {
        val snapPosition = snapHelper.getSnapPosition(recyclerView)
        val snapPositionChanged = snapFlow.value != snapPosition
        if (snapPositionChanged) {
            snapFlow.value = snapPosition
        }
    }
}