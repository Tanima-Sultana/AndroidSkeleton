package com.example.androidskeleton.domain.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T> : Fragment() {

    private var viewBinding: ViewBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = constructViewBinding()
        viewBinding?.let { init(it) }
        return viewBinding?.root
    }

    @Suppress("UNCHECKED_CAST")
    fun getViewBinding(): T = viewBinding as T

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    abstract fun constructViewBinding(): ViewBinding
    abstract fun init(viewBinding: ViewBinding)
}