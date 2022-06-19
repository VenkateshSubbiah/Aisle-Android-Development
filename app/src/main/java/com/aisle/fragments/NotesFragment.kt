package com.aisle.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.aisle.R
import com.aisle.databinding.NotesFragmentBinding
import com.aisle.helpers.SharedPrefHelper
import com.aisle.viewmodels.NotesViewModel
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.BlurTransformation
import kotlinx.coroutines.launch

class NotesFragment : Fragment() {

    private lateinit var notesViewModel: NotesViewModel
    private lateinit var binding: NotesFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        notesViewModel = ViewModelProvider(requireActivity())[NotesViewModel::class.java]
        binding = NotesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val token = SharedPrefHelper.fetchToken(requireContext())
        if (token != null) {
            lifecycleScope.launch {
                val notesResponse = notesViewModel.fetchNotes(token)

                val inviteProfile = notesResponse?.invites?.profiles
                val generalInfo = inviteProfile?.get(0)?.generalInformation
                val inviteProfileAvatar =
                    inviteProfile?.get(0)?.photos?.find { it?.status.equals("avatar") }?.photo
                binding.textProfileName.text =
                    resources.getString(
                        R.string.profile_name, generalInfo?.firstName, generalInfo?.age
                    )
                Picasso.get()
                    .load(inviteProfileAvatar)
                    .into(binding.imageProfile)

                val likeProfiles = notesResponse?.likes?.profiles
                binding.textBottomLeft.text = likeProfiles?.get(0)?.firstName
                binding.textBottomRight.text = likeProfiles?.get(1)?.firstName

                val subscribed = inviteProfile?.get(0)?.hasActiveSubscription == true
                val blurTrans = BlurTransformation(context, 30, 3)

                val imageBottomLeftCreator = Picasso.get()
                    .load(likeProfiles?.get(0)?.avatar)
                if (!subscribed) {
                    imageBottomLeftCreator.transform(blurTrans)
                }
                imageBottomLeftCreator.into(binding.imageBottomLeft)

                val imageBottomRightCreator = Picasso.get()
                    .load(likeProfiles?.get(1)?.avatar)
                if (!subscribed) {
                    imageBottomRightCreator.transform(blurTrans)
                }
                imageBottomRightCreator.into(binding.imageBottomRight)

                binding.groupPremium.visibility = if (subscribed) View.GONE else View.VISIBLE
            }
        }
    }

}