package com.aisle.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aisle.databinding.MatchesFragmentBinding

class MatchesFragment : Fragment() {

    private lateinit var binding: MatchesFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MatchesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}