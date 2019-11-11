package com.rmakiyama.insetterdemo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.rmakiyama.insetterdemo.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var binding: MainFragmentBinding
    private val viewModel: MainViewModel by viewModels()
    private val adapter = DemoListAdapter()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,

            savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false).apply {
            list.adapter = adapter
        }
        return binding.root
    }

    override fun onViewCreated(
            view: View,
            savedInstanceState: Bundle?
    ) {
        viewModel.texts.observe(viewLifecycleOwner) { adapter.submitList(it) }
    }
}
