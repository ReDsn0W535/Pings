package com.production.commonui

import android.os.Bundle
import android.view.View
import com.production.commonui.databinding.StartFragmentBinding
import com.production.framework.fragment.BaseFragment
import com.production.framework.viewbinding.viewBinding
import com.production.navigation.NavigationFlow
import com.production.navigation.ToFlowNavigatable

class StartFragment : BaseFragment<StartFragmentBinding>(R.layout.start_fragment) {
    override val binding: StartFragmentBinding by viewBinding(StartFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button1.setOnClickListener {
            (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.SettingsFlow)
        }
        binding.button2.setOnClickListener {
            (requireActivity() as ToFlowNavigatable).navigateToFlow(NavigationFlow.DashboardFlow)
        }
    }

}