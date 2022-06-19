package com.aisle.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aisle.databinding.DiscoverFragmentBinding

class DiscoverFragment : Fragment() {

    private lateinit var binding: DiscoverFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DiscoverFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}