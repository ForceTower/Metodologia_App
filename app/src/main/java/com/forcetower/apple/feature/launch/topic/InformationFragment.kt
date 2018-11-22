package com.forcetower.apple.feature.launch.topic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.forcetower.apple.databinding.FragmentInformationBinding
import com.forcetower.apple.feature.shared.provideActivityViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class InformationFragment: DaggerFragment() {
    @Inject lateinit var factory: ViewModelProvider.Factory
    private lateinit var binding: FragmentInformationBinding
    private lateinit var informationVM: InformationViewModel
    private lateinit var subjectId: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        informationVM = provideActivityViewModel(factory)
        subjectId = requireNotNull(arguments).getString("subject_id")?: "invalid"
        return FragmentInformationBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.up.setOnClickListener { findNavController().popBackStack() }


        val informationAdapter = InformationAdapter()
        binding.informationRecycler.apply {
            adapter = informationAdapter
        }

        //TODO observar a coleção de informações e assunto
    }
}