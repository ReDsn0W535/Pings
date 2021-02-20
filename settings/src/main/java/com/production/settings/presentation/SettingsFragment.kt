package com.production.settings.presentation

import androidx.fragment.app.Fragment
import com.production.framework.fragment.BaseFragment
import com.production.framework.viewbinding.viewBinding
import com.production.settings.R
import com.production.settings.databinding.SettingsFragmentBinding

class SettingsFragment : BaseFragment<SettingsFragmentBinding>(R.layout.settings_fragment) {
    override val binding: SettingsFragmentBinding by viewBinding(SettingsFragmentBinding::bind)
}