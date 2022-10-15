package com.example.androidskeleton.ui.home


import androidx.fragment.app.viewModels
import androidx.viewbinding.ViewBinding
import com.example.androidskeleton.databinding.FragmentHomeBinding
import com.example.androidskeleton.domain.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private val homeViewModel: HomeViewModel by viewModels()

    override fun constructViewBinding(): ViewBinding = FragmentHomeBinding.inflate(layoutInflater)

    override fun init(viewBinding: ViewBinding) {
        homeViewModel.getPraySchedule()
        initUi()
        fetchPraySchedules()
    }

    private fun fetchPraySchedules() {

    }

    private fun initUi() {

    }

}