package com.aisle.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.Selection
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.aisle.R
import com.aisle.databinding.PhoneNumberFragmentBinding
import com.aisle.viewmodels.LoginViewModel
import com.google.android.material.internal.TextWatcherAdapter
import kotlinx.coroutines.launch

class PhoneNumberFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: PhoneNumberFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        loginViewModel = ViewModelProvider(requireActivity())[LoginViewModel::class.java]
        binding = PhoneNumberFragmentBinding.inflate(inflater, container, false)
        binding.loginViewModel = loginViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginViewModel.countryCode.postValue(resources.getString(R.string.default_country_code))
        binding.buttonContinue.setOnClickListener {
            lifecycleScope.launch {
                val success = loginViewModel.checkPhoneNum()
                if (success) {
                    findNavController().navigate(R.id.action_authenticationFragment_to_otpFragment)
                } else {
                    Toast.makeText(
                        requireContext(), "Wrong phone number", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        binding.editCountryCode.addTextChangedListener(@SuppressLint("RestrictedApi")
        object : TextWatcherAdapter() {
            override fun afterTextChanged(s: Editable) {
                if (!s.toString().startsWith("+")) {
                    binding.editCountryCode.setText("+")
                    Selection.setSelection(
                        binding.editCountryCode.text,
                        binding.editCountryCode.text.length
                    )
                }
            }
        })
    }

}