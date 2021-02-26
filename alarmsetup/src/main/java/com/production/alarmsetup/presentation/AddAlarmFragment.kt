package com.production.alarmsetup.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearSnapHelper
import com.production.alarmsetup.R
import com.production.alarmsetup.databinding.AddAlarmFragmentBinding
import com.production.alarmsetup.presentation.timepicker.Orientation
import com.production.alarmsetup.presentation.timepicker.TimePickerAdapter
import com.production.alarmsetup.presentation.timepicker.TimePickerScrollListener
import com.production.framework.fragment.BaseFragment
import com.production.framework.viewbinding.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay


@AndroidEntryPoint
class AddAlarmFragment : BaseFragment<AddAlarmFragmentBinding>(R.layout.add_alarm_fragment) {
    private val viewModel: AddAlarmViewModel by viewModels()

    override val binding: AddAlarmFragmentBinding by viewBinding(AddAlarmFragmentBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val hoursSnapHelper = LinearSnapHelper()
        val hoursPickerScrollListener = TimePickerScrollListener(hoursSnapHelper)
        binding.hoursPicker.adapter =
            TimePickerAdapter(
                resources.getStringArray(R.array.hours).toList(),
                hoursPickerScrollListener.snapFlow,
                Orientation.END
            )
        binding.hoursPicker.layoutManager?.scrollToPosition(Int.MAX_VALUE / 2)
        binding.hoursPicker.addOnScrollListener(hoursPickerScrollListener)
        hoursSnapHelper.attachToRecyclerView(binding.hoursPicker)

        val minutesSnapHelper = LinearSnapHelper()
        val minutesPickerScrollListener = TimePickerScrollListener(minutesSnapHelper)
        binding.minutesPicker.adapter =
            TimePickerAdapter(
                resources.getStringArray(R.array.minutes).toList(),
                minutesPickerScrollListener.snapFlow,
                Orientation.START
            )
        binding.minutesPicker.layoutManager?.scrollToPosition(Int.MAX_VALUE / 2)
        binding.minutesPicker.addOnScrollListener(minutesPickerScrollListener)
        minutesSnapHelper.attachToRecyclerView(binding.minutesPicker)

        binding.labelButton.setOnClickListener {
            Toast.makeText(requireContext(), "labelButton clicked", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launchWhenResumed {
            delay(100)
            binding.minutesPicker.smoothScrollBy(0, 500)
            binding.hoursPicker.smoothScrollBy(0, -500)
        }
    }
}