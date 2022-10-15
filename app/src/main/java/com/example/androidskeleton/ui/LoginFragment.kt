package com.example.androidskeleton.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidskeleton.R
import com.example.androidskeleton.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginFragment : Fragment() {
private lateinit var binding: FragmentLoginBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        configureUI()
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun configureUI() {
        binding.btnLogin.setOnClickListener { onLoginClicked() }
    }

    private fun onLoginClicked() {
        val mainActivity = activity as MainActivity
        //mainActivity.closeKeyboard()
        mainActivity.login(
            binding.userEmailEditText.text.toString(),
            binding.userPasswordEditText.text.toString()
        )
    }

}