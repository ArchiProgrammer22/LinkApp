package com.example.webviewapp.presentation.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.webviewapp.R
import com.example.webviewapp.UtilConstants
import com.example.webviewapp.databinding.FragmentLoadingBinding
import com.example.webviewapp.presentation.viewmodels.LoadingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoadingFragment : Fragment() {

    private val viewModel: LoadingViewModel by viewModels()
    private lateinit var binding: FragmentLoadingBinding

    private val sharedPreferences: SharedPreferences by lazy {
        requireActivity().getPreferences(Context.MODE_PRIVATE)
    }
    private val sharedEditor: SharedPreferences.Editor by lazy {
        sharedPreferences.edit()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoadingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (isItFirstTime()) {
            viewModel.getLink().observe(viewLifecycleOwner) {
                viewModel.insertLocalLink(it)
                navigate(it.link)
            }
        } else {
            viewModel.getLocalLink().observe(viewLifecycleOwner) {
                navigate(it.home)
            }
        }
    }

    private fun isItFirstTime(): Boolean {
        if (sharedPreferences.getBoolean(UtilConstants.FIRST, true)) {
            sharedEditor.putBoolean(UtilConstants.FIRST, false)
            sharedEditor.commit()
            sharedEditor.apply()
            return true
        }
        return false
    }

    private fun navigate(url: String) {
        findNavController().navigate(
            R.id.action_loadingFragment_to_webViewFragment,
            bundleOf(UtilConstants.PAGE to url)
        )
    }
}