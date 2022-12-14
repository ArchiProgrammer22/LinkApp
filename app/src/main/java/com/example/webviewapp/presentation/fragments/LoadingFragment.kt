package com.example.webviewapp.presentation.fragments

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoadingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (viewModel.isItFirstTime()) {
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

    private fun navigate(url: String) {
        findNavController().navigate(
            R.id.action_loadingFragment_to_webViewFragment,
            bundleOf(UtilConstants.PAGE to url)
        )
    }
}