package com.production.overview

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.production.framework.fragment.BaseFragment
import com.production.framework.viewbinding.viewBinding
import com.production.overview.databinding.OverviewFragmentBinding

class OverviewFragment : BaseFragment<OverviewFragmentBinding>(R.layout.overview_fragment) {
    override val binding: OverviewFragmentBinding by viewBinding(OverviewFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button1.setOnClickListener {
            findNavController().navigate(OverviewFragmentDirections.actionOverviewFragmentToNextFragment())
        }
    }

}