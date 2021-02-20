package com.production.alarmsetup.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearSnapHelper
import com.production.alarmsetup.R
import com.production.alarmsetup.databinding.AddAlarmFragmentBinding
import com.production.alarmsetup.presentation.timepicker.TimePickerAdapter
import com.production.alarmsetup.presentation.timepicker.TimePickerScrollListener
import com.production.framework.fragment.BaseFragment
import com.production.framework.viewbinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddAlarmFragment : BaseFragment<AddAlarmFragmentBinding>(R.layout.add_alarm_fragment) {
    private val viewModel: AddAlarmViewModel by viewModels()

    override val binding: AddAlarmFragmentBinding by viewBinding(AddAlarmFragmentBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val hoursSnapHelper = LinearSnapHelper()
        val hoursPickerScrollListener = TimePickerScrollListener(hoursSnapHelper)
        binding.hoursPicker.adapter =
            TimePickerAdapter(resources.getStringArray(R.array.hours).toList(), hoursPickerScrollListener.snapFlow)
        binding.hoursPicker.layoutManager?.scrollToPosition(Integer.MAX_VALUE / 2);
        hoursSnapHelper.attachToRecyclerView(binding.hoursPicker)
        binding.hoursPicker.addOnScrollListener(hoursPickerScrollListener)
        val minutesSnapHelper = LinearSnapHelper()
        val minutesPickerScrollListener = TimePickerScrollListener(minutesSnapHelper)
        binding.minutesPicker.adapter = TimePickerAdapter(resources.getStringArray(R.array.minutes).toList(),
            minutesPickerScrollListener.snapFlow)
        binding.minutesPicker.layoutManager?.scrollToPosition(Integer.MAX_VALUE / 2)
        minutesSnapHelper.attachToRecyclerView(binding.minutesPicker)
        binding.minutesPicker.addOnScrollListener(minutesPickerScrollListener)
    }
}