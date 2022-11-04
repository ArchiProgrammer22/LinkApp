package com.example.webviewapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.webviewapp.UtilConstants
import com.example.webviewapp.databinding.FragmentWebViewBinding
import com.example.webviewapp.presentation.viewmodels.WebViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WebViewFragment : Fragment() {

    private lateinit var binding: FragmentWebViewBinding
    private val viewModel: WebViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWebViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.setUrl(arguments?.getString(UtilConstants.PAGE) ?: UtilConstants.DEFAULT)
        viewModel.getWebView().observe(viewLifecycleOwner) {
            binding.webView.addView(it)
        }
        backCheck()
    }

    private fun backCheck() {
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if(!viewModel.hasHistory()) {
                        requireActivity().finish()
                    }
                }
            })
    }
}