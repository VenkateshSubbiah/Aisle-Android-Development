package com.aisle.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.aisle.MainActivity
import com.aisle.databinding.OtpFragmentBinding
import com.aisle.helpers.SharedPrefHelper
import com.aisle.viewmodels.LoginViewModel
import kotlinx.coroutines.launch

class OtpFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: OtpFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        loginViewModel = ViewModelProvider(requireActivity())[LoginViewModel::class.java]
        binding = OtpFragmentBinding.inflate(inflater, container, false)
        binding.loginViewModel = loginViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textPhoneNum.setOnClickListener {
            loginViewModel.stopTimer()
            NavHostFragment.findNavController(this).navigateUp()
        }
        binding.imageEditPhone.setOnClickListener {
            loginViewModel.stopTimer()
            NavHostFragment.findNavController(this).navigateUp()
        }

        binding.buttonContinue.setOnClickListener {
            lifecycleScope.launch {
                val success = loginViewModel.checkOtp(binding.editOtp.text.toString())
                if (success) {
                    SharedPrefHelper.saveToken(requireContext(), loginViewModel.token)
                    loginViewModel.stopTimer()
                    val intent = Intent(requireActivity(), MainActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish()
                } else {
                    Toast.makeText(requireContext(), "Wrong OTP", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }


}