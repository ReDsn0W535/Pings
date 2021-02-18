package com.production.framework.fragment

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<B : ViewBinding>(@LayoutRes layout: Int) : Fragment(layout) {
    abstract val binding: B
}